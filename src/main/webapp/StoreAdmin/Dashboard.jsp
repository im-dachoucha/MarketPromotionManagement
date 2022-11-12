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
                <c:if test="${promotion_error}">
                    asdfljasdlfkjasdflkj
                </c:if>
                <!-- component -->
                <div class="bg-white p-8 rounded-md w-full">
                    <div class=" flex items-center justify-between pb-6">
                        <div>
                            <h2 class="text-gray-600 text-2xl font-semibold" id="title">Promotions</h2>
                        </div>
                        <div class="flex items-center justify-end">
                            <div class=" space-x-8">
                                <button class="bg-indigo-600 px-4 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer"
                                        id="new">New promo
                                </button>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div
                                class="hidden -mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto"
                                id="add"
                        >
                            <form class="w-full" action="${pageContext.request.contextPath}/store-admin/promotions"
                                  method="post">
                                <div class="flex flex-wrap -mx-3 mb-6">
                                    <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                                        <label
                                                class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                                for="startDate"
                                        >
                                            Start Date
                                        </label>
                                        <input
                                                class="appearance-none block w-full text-gray-700 border focus:border-2 focus:border-blue-400 rounded py-3 px-4 mb-3 leading-tight focus:outline-none bg-white border-gray-500"
                                                name="startDate"
                                                id="startDate"
                                                type="date"
                                        />
                                    </div>
                                    <div class="w-full md:w-1/2 px-3">
                                        <label
                                                class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                                for="endDate"
                                        >
                                            End Date
                                        </label>
                                        <input
                                                class="appearance-none block w-full text-gray-700 border focus:border-2 focus:border-blue-400 rounded py-3 px-4 leading-tight focus:outline-none bg-white border-gray-500"
                                                name="endDate"
                                                id="endDate"
                                                type="date"
                                        />
                                    </div>
                                </div>
                                <div class="flex flex-wrap -mx-3 mb-6">
                                    <div class="w-full px-3">
                                        <label
                                                class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                                for="description"
                                        >
                                            Description
                                        </label>
                                        <textarea
                                                class="appearance-none block w-full text-gray-700 border focus:border-2 focus:border-blue-400 rounded py-3 px-4 mb-3 leading-tight focus:outline-none bg-white border-gray-500"
                                                name="description"
                                                id="description"
                                                cols="30"
                                                rows="5"
                                                placeholder="Desc"
                                        ></textarea>
                                    </div>
                                </div>
                                <div class="flex flex-wrap -mx-3 mb-2">
                                    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                                        <label
                                                class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                                for="discount"
                                        >
                                            Discount
                                        </label>
                                        <input
                                                class="appearance-none block w-full text-gray-700 border focus:border-2 focus:border-blue-400 rounded py-3 px-4 leading-tight focus:outline-none bg-white border-gray-500"
                                                id="discount"
                                                name="discount"
                                                type="number"
                                                step="0.05"
                                                max=".5"
                                                min="0"
                                                placeholder="e.g: 0.3"
                                        />
                                    </div>
                                    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                                        <label
                                                class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                                for="subDepartment"
                                        >
                                            SubDepartment
                                        </label>
                                        <div class="relative">
                                            <input type="number" name="subDepartment" id="subDepartment"
                                                   class="block appearance-none w-full border focus:border-2 focus:border-blue-400 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none bg-white border-gray-500">
                                            <%--                                            <select--%>
                                            <%--                                                    class="block appearance-none w-full border focus:border-2 focus:border-blue-400 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none bg-white border-gray-500"--%>
                                            <%--                                                    id="subDepartment"--%>
                                            <%--                                            >--%>
                                            <%--                                                <option disabled selected>--%>
                                            <%--                                                    --Select a subDepartment----%>
                                            <%--                                                </option>--%>
                                            <%--                                            </select>--%>
                                            <%--                                            <div--%>
                                            <%--                                                    class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700"--%>
                                            <%--                                            >--%>
                                            <%--                                                <svg--%>
                                            <%--                                                        class="fill-current h-4 w-4"--%>
                                            <%--                                                        xmlns="http://www.w3.org/2000/svg"--%>
                                            <%--                                                        viewBox="0 0 20 20"--%>
                                            <%--                                                >--%>
                                            <%--                                                    <path--%>
                                            <%--                                                            d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"--%>
                                            <%--                                                    />--%>
                                            <%--                                                </svg>--%>
                                            <%--                                            </div>--%>
                                        </div>
                                    </div>
                                    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0 flex justify-end items-end">
                                        <input
                                                class="bg-indigo-600 px-6 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer"
                                                id="submit"
                                                type="submit"
                                                value="Add promotion"
                                        />
                                    </div>
                                </div>
                            </form>
                        </div>
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

                                                        >
                                                            <form class="w-full h-full flex items-center justify-center"
                                                                  action="${pageContext.request.contextPath}/store-admin/delete-promotion"
                                                                  method="post">
                                                                <input type="text"
                                                                       name="promoId"
                                                                       value="<c:out value='${promotion.getId()}'/>"
                                                                       hidden>
                                                                <button type="submit"><i
                                                                        class="fa-sharp fa-solid fa-trash text-red-500 cursor-pointer"></i>
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

<script>
    const toggleBtn = document.querySelector("#new")
    const title = document.querySelector("#title")
    const addForm = document.querySelector("#add")
    const display = document.querySelector("#display")

    const toggleDisplay = () => {
        if (addForm.classList.contains("hidden")) {
            toggleBtn.textContent = "Cancel"
            title.textContent = "Add promotion"
            addForm.classList.remove("hidden")
            display.classList.add("hidden")
        } else {
            toggleBtn.textContent = "New promo"
            title.textContent = "Promotions"
            addForm.classList.add("hidden")
            display.classList.remove("hidden")
        }
    }

    toggleBtn.addEventListener("click", toggleDisplay)
</script>
