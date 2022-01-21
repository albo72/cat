<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template_page tittle="Котик">
    <jsp:body>
        <div class="container h-100">
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-2">
                    <div class="image">
                        <img src="${pageContext.request.contextPath}${cat.catAvatar}" alt="">
                    </div>
                </div>
                <div class="col-sm-7">
                    Кот - ${cat.name}<br>
                    Возраст - ${cat.age} год<br>
                    Уровень счастья - ${cat.happiness}<br>
                    Уровень сытости - ${cat.satiety}<br>
                </div>
            </div>
            <br><br>
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-9">
                    <form action="http://localhost:8081/cat_stats" method="get">
                        <label for="cat">Выберите действие</label>
                        <select name="catAction" id="cat">
                            <c:forEach var="action" items="${actions}">
                                <option value="${action.key}">${action.value}</option>
                            </c:forEach>
                        </select>
                        <button type="submit">Подтвердить</button>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template_page>





