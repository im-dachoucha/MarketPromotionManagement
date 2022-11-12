<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Department managers -store admin-</title>
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
                            <h2 class="text-gray-600 text-2xl font-semibold" id="title">Managers</h2>
                        </div>
                        <div class="flex items-center justify-end">
                            <div class=" space-x-8">
                                <button class="bg-indigo-600 px-4 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer"
                                        id="new">New manager
                                </button>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div
                                class="hidden -mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto"
                                id="add"
                        >
                            <form class="w-full" action="${pageContext.request.contextPath}/store-admin/managers"
                                  method="post">
                                <div class="flex flex-wrap -mx-3 mb-6">
                                    <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                                        <label
                                                class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                                for="email"
                                        >
                                            Email
                                        </label>
                                        <input
                                                class="appearance-none block w-full text-gray-700 border focus:border-2 focus:border-blue-400 rounded py-3 px-4 mb-3 leading-tight focus:outline-none bg-white border-gray-500"
                                                name="email"
                                                id="email"
                                                type="email"
                                        />
                                    </div>
                                    <div class="w-full md:w-1/2 px-3">
                                        <label
                                                class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                                for="password"
                                        >
                                            Password
                                        </label>
                                        <input
                                                class="appearance-none block w-full text-gray-700 border focus:border-2 focus:border-blue-400 rounded py-3 px-4 leading-tight focus:outline-none bg-white border-gray-500"
                                                name="password"
                                                id="password"
                                                type="password"
                                        />
                                    </div>
                                </div>
                                <div class="flex flex-wrap -mx-3 mb-2">
                                    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                                        <label
                                                class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                                for="department"
                                        >
                                            SubDepartment
                                        </label>
                                        <div class="relative">
                                            <select
                                                    class="block appearance-none w-full border focus:border-2 focus:border-blue-400 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none bg-white border-gray-500"
                                                    id="department"
                                                    name="department"

                                            >
                                                <option disabled selected>
                                                    --Select a department--
                                                </option>
                                                <c:choose>
                                                    <c:when test="${departments != null}">
                                                        <c:forEach items="${departments}" var="department">
                                                            <option value="${department.getId()}">
                                                                <c:out value="${department.getName()}"/>
                                                            </option>
                                                        </c:forEach>
                                                    </c:when>
                                                </c:choose>
                                            </select>
                                            <div
                                                    class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700"
                                            >
                                                <svg
                                                        class="fill-current h-4 w-4"
                                                        xmlns="http://www.w3.org/2000/svg"
                                                        viewBox="0 0 20 20"
                                                >
                                                    <path
                                                            d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"
                                                    />
                                                </svg>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0 flex justify-end items-end">
                                        <input
                                                class="bg-indigo-600 px-6 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer"
                                                id="submit"
                                                type="submit"
                                                value="Add manager"
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
                                                Email
                                            </th>
                                            <th
                                                    class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider"
                                            >
                                                Department
                                            </th>
                                            <th
                                                    class="px-2 py-3 border-b-2 border-gray-200 bg-gray-100 text-center text-xs font-semibold text-gray-600 uppercase tracking-wider"
                                            >
                                                Actions
                                            </th>
                                        </tr>
                                    </thead>
                                    <c:choose>
                                        <c:when test="${managers != null}">
                                            <tbody>
                                                <c:forEach items="${managers}" var="manager">
                                                    <tr>
                                                        <td
                                                                class="px-2 py-5 border-b border-gray-200 bg-white text-center text-sm"
                                                        >
                                                            <p class="text-gray-900 whitespace-no-wrap">
                                                                <c:out value="${manager.getId()}"/>
                                                            </p>
                                                        </td>
                                                        <td
                                                                class="px-5 py-5 border-b border-gray-200 bg-white text-center text-sm"
                                                        >
                                                            <p class="text-gray-900 whitespace-no-wrap">
                                                                <c:out value="${manager.getEmail()}"/>
                                                            </p>
                                                        </td>
                                                        <td
                                                                class="px-5 py-5 border-b border-gray-200 bg-white text-center text-sm"
                                                        >
                                                            <p class="text-gray-900 whitespace-no-wrap">
                                                                <c:out value="${manager.getDepartment().getName()}"/>
                                                            </p>
                                                        </td>
                                                        <td>
                                                            <form class="w-full h-full flex items-center justify-center"
                                                                  action="${pageContext.request.contextPath}/store-admin/delete-manager"
                                                                  method="post">
                                                                <input type="text"
                                                                       name="promoId"
                                                                       value="<c:out value='${manager.getId()}'/>"
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
            title.textContent = "Add manager"
            addForm.classList.remove("hidden")
            display.classList.add("hidden")
        } else {
            toggleBtn.textContent = "New manager"
            title.textContent = "Managers"
            addForm.classList.add("hidden")
            display.classList.remove("hidden")
        }
    }

    toggleBtn.addEventListener("click", toggleDisplay)
</script>
