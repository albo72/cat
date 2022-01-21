<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>



<t:template_page tittle="Главная">
    <jsp:body>
        <div class="container h-100 text-center">
            <div class="row h-100 justify-content-center align-items-center">
                <form class="row g-3" action="/" method="post">
                    <div class="col-sm-12 fs-3">
                        Вас приветсвует симулятор кота!<br>
                        Для начала введите имя кота
                    </div>
                    <br>
                    <br>
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <%--@declare id="name"--%><label for="name" class="form-label"></label>
                        <input type="text" class="form-control" name="name" required placeholder="Введите имя кота">
                    </div>
                    <div class="col-sm-3"></div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary">Создать</button>
                    </div>
                </form>
            </div>
        </div>
    </jsp:body>
</t:template_page>





