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
                        <img src="${pageContext.request.contextPath}/${cat.action.avatar}" alt=""
                             style="width: 300px">
                    </div>
                    <br>
                    <div class="fs-4">
                        ${cat.action.catSpeech}
                    </div>
                </div>
                <div class="col-sm-7">
                    Кот - ${cat.name}<br>
                    Возраст - ${cat.age}<br>
                    Уровень счастья - ${cat.happiness}<br>
                    Уровень сытости - ${cat.satiety}<br>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-9">
                    <form action="${pageContext.request.contextPath}/cat_stats" method="get">
                        <label for="cat">Выберите действие</label>
                        <select name="catAction" id="cat">
                            <c:forEach var="action" items="${actions}">
                                <option value="${action}">${action.title}</option>
                            </c:forEach>
                        </select>
                        <button type="submit">Подтвердить</button>
                    </form>
                    <div class="button-start">
                        <a class="btn btn-dark" href="${pageContext.request.contextPath}/delete" role="button">Удалить кота</a>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template_page>





