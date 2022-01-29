package com.albo.cat.controller;

import static com.albo.cat.util.ConstantHolder.START_VALUE_OF_CAT_HAPPINESS;
import static com.albo.cat.util.ConstantHolder.START_VALUE_OF_CAT_SATIETY;
import static com.albo.cat.util.ConstantHolder.START_VALUE_OF_CAT_AGE;

import com.albo.cat.dto.CatCreationDTO;
import com.albo.cat.entity.Cat;
import com.albo.cat.dto.CatDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.albo.cat.util.ConstantHolder.REDIRECT;

@Controller
public class WelcomePageController {
    private final Cat cat;
    @Value("${upload.path}")
    private String uploadPath;

    private static final String WELCOME_PAGE_NAME = "welcome";
    private static final String CAT_STATS_CONTROLLER_NAME = "cat_stats";

    public WelcomePageController(Cat cat) {
        this.cat = cat;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        if (!cat.isCreated()) {
            return WELCOME_PAGE_NAME;
        } else {
            return REDIRECT + CAT_STATS_CONTROLLER_NAME;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getCatName(@ModelAttribute("name") String name, @RequestParam("file") MultipartFile file) {
        /*if (!file.isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultName = uuidFile + "." + StringUtils.cleanPath(file.getOriginalFilename());
            Path copyLocation = Paths
                    .get(uploadDir + File.separator + resultName);
            try {
                Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Файл не загружен");
            }
            Action.REST.setAvatar(resultName);
        }*/
        cat.setName(name);
        cat.setAge(START_VALUE_OF_CAT_AGE);
        cat.setHappiness(START_VALUE_OF_CAT_HAPPINESS);
        cat.setSatiety(START_VALUE_OF_CAT_SATIETY);
        cat.setCreated(true);
        return REDIRECT + CAT_STATS_CONTROLLER_NAME;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCat() {
        cat.setCreated(false);
        return REDIRECT;
    }

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getCat() {
        if (!cat.isCreated()) {
            return ResponseEntity.badRequest().body("Кот не создан");
        }
        return ResponseEntity.ok(CatDTO.getCatDTO(cat));
    }

    @RequestMapping(value = "/api", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createCat(@RequestBody CatCreationDTO catDto) {
        if (!cat.isCreated()) {
            cat.setCreated(true);
            cat.setName(catDto.getName());
            if (catDto.getAge() != null) {
                cat.setAge(catDto.getAge());
            } else {
                cat.setAge(START_VALUE_OF_CAT_AGE);
            }
            cat.setHappiness(START_VALUE_OF_CAT_HAPPINESS);
            cat.setSatiety(START_VALUE_OF_CAT_SATIETY);
            return ResponseEntity.ok("Кот успешно создан!");
        } else {
            return ResponseEntity.badRequest().body("Кот уже создан!");
        }
    }

    @RequestMapping(value = "/api", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCatApi() {
        if (cat.isCreated()) {
            cat.setCreated(false);
            return ResponseEntity.ok("Кот успешно удалён!");
        } else {
            return ResponseEntity.badRequest().body("Кот не создан!");
        }
    }

    @RequestMapping(value = "/api", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCatApi(@RequestBody CatCreationDTO catDto) {
        if (!cat.isCreated()) {
            return ResponseEntity.badRequest().body("Кот не создан");
        }
        if (catDto.getName() != null) {
            cat.setName(catDto.getName());
        }
        if (catDto.getAge() != null) {
            cat.setAge(catDto.getAge());
        }
        return ResponseEntity.ok("Кот успешно обновлён!");
    }
}
