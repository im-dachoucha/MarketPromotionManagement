<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Promotions -store admin-</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    </head>
    <body class="">
        <div
                class="grid h-[100vh] grid-cols-12"
                style="grid-template-rows: 4rem 1fr"
        >
            <jsp:include page="inc/Navbar.jsp"/>
            <jsp:include page="inc/Sidebar.jsp"/>
            <div class="col-span-10">
                <!-- component -->
                <div class="bg-white p-8 rounded-md w-full">
                    <div class=" flex items-center justify-start pb-6">
                        <div>
                            <h2 class="text-gray-600 text-2xl font-semibold" id="title">Promotions</h2>
                        </div>
                    </div>
                    <div>
                        <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto" id="display">
                            <div
                                    class="inline-block min-w-full shadow rounded-lg overflow-hidden"
                            >
                                <table class="min-w-full leading-normal">
                                    <thead>
                                        <tr>
                                            <th
                                                    class="px-2 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider"
                                            >
                                                #
                                            </th>
                                            <th
                                                    class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider"
                                            >
                                                Description
                                            </th>
                                            <th
                                                    class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider"
                                            >
                                                State
                                            </th>
                                            <th
                                                    class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider"
                                            >
                                                Start date
                                            </th>
                                            <th
                                                    class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider"
                                            >
                                                End date
                                            </th>
                                            <th
                                                    class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider"
                                            >
                                                Discount
                                            </th>
                                            <th
                                                    class="px-2 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider"
                                            >
                                                Actions
                                            </th>
                                        </tr>
                                    </thead>
                                    <c:choose>
                                        <c:when test="${promotions != null}">
                                            <tbody>
                                                <c:forEach items="${promotions}" var="promotion">
                                                    <tr>
                                                        <td
                                                                class="px-2 py-5 border-b border-gray-200 bg-white text-center text-sm"
                                                        >
                                                            <p class="text-gray-900 whitespace-no-wrap">
                                                                <c:out value="${promotion.getId()}"/>
                                                            </p>
                                                        </td>
                                                        <td
                                                                class="px-5 py-5 border-b border-gray-200 bg-white text-center text-sm"
                                                        >
                                                            <p class="text-gray-900 whitespace-no-wrap">
                                                                <c:out value="${promotion.getDescription()}"/>
                                                            </p>
                                                        </td>
                                                        <td
                                                                class="px-5 py-5 border-b border-gray-200 bg-white text-center text-sm"
                                                        >
                                                            <p class="text-gray-900 whitespace-no-wrap">
                          <span
                                  class="relative inline-block px-3 py-1 font-semibold text-green-900 leading-tight"
                          >
                            <span
                                    class="absolute inset-0 bg-<c:out value="${promotion.getState().equals('pending') ? 'blue' :(promotion.getState().equals('accepted') ? 'green' : (promotion.getState().equals('not-treated') ? 'orange' : 'red')) }"/>-200 opacity-50 rounded-full"
                            ></span>
                            <span class="relative"><c:out value="${promotion.getState()}"/></span>
                          </span>
                                                            </p>
                                                        </td>
                                                        <td
                                                                class="px-5 py-5 border-b border-gray-200 bg-white text-center text-sm"
                                                        >
                                                            <p class="text-gray-900 whitespace-no-wrap">
                                                                <c:out value="${promotion.getStartdate()}"/>
                                                            </p>
                                                        </td>
                                                        <td
                                                                class="px-5 py-5 border-b border-gray-200 bg-white text-center text-sm"
                                                        >
                                                            <p class="text-gray-900 whitespace-no-wrap">
                                                                <c:out value="${promotion.getEnddate()}"/>
                                                            </p>
                                                        </td>
                                                        <td
                                                                class="px-5 py-5 border-b border-gray-200 bg-white text-center text-sm"
                                                        >
                                                            <c:out value="${promotion.getDiscount()}"/>
                                                        </td>
                                                        <td
                                                                class="px-5 py-5 border-b border-gray-200 bg-white flex justify-center gap-7"
                                                        >
                                                            <form action="${pageContext.request.contextPath}/department-manager/accept-promotion"
                                                                  method="post">
                                                                <input type="text"
                                                                       name="promoId"
                                                                       value="<c:out value='${promotion.getId()}'/>"
                                                                       hidden>
                                                                <button type="submit">
                                                                    <i class="fa-solid fa-check text-green-500"></i>
                                                                </button>
                                                            </form>
                                                            <form action="${pageContext.request.contextPath}/department-manager/refuse-promotion"
                                                                  method="post">
                                                                <input type="text"
                                                                       name="promoId"
                                                                       value="<c:out value='${promotion.getId()}'/>"
                                                                       hidden>
                                                                <button type="submit">
                                                                    <i class="fa-solid fa-x text-red-500"></i>
                                                                </button>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </c:when>
                                    </c:choose>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

<%--<script>--%>
<%--    const toggleBtn = document.querySelector("#new")--%>
<%--    const title = document.querySelector("#title")--%>
<%--    const addForm = document.querySelector("#add")--%>
<%--    const display = document.querySelector("#display")--%>

<%--    const toggleDisplay = () => {--%>
<%--        if (addForm.classList.contains("hidden")) {--%>
<%--            toggleBtn.textContent = "Cancel"--%>
<%--            title.textContent = "Add promotion"--%>
<%--            addForm.classList.remove("hidden")--%>
<%--            display.classList.add("hidden")--%>
<%--        } else {--%>
<%--            toggleBtn.textContent = "New promo"--%>
<%--            title.textContent = "Promotions"--%>
<%--            addForm.classList.add("hidden")--%>
<%--            display.classList.remove("hidden")--%>
<%--        }--%>
<%--    }--%>

<%--    toggleBtn.addEventListener("click", toggleDisplay)--%>
<%--</script>--%>
