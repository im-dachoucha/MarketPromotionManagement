<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
    </head>
    <body class="">
        <div
                class="grid h-[100vh] grid-cols-12"
                style="grid-template-rows: 4rem 1fr"
        >
            <nav
                    class="col-span-full row-span-1 flex items-center justify-between px-9 bg-teal-100"
            >
                <h3 class="text-2xl font-bold">Anonymous Market</h3>
                <lottie-player
                        src="https://assets7.lottiefiles.com/private_files/lf30_amhtk28o.json"
                        class="mr-8 h-20 w-24 cursor-pointer"
                        background="transparent"
                        speed="1"
                        loop
                        autoplay
                ></lottie-player>
            </nav>
            <aside class="col-span-2 bg-teal-50 pt-4">
                <div class="flex flex-col items-center gap-16">
                    <a class="font-semibold text-xl" href="#">Promotions</a>
                    <a class="font-semibold text-xl" href="#">Managers</a>
                    <a class="font-semibold text-xl" href="#">Log out</a>
                </div>
            </aside>
            <div class="col-span-10">
                <!-- component -->
                <div class="bg-white p-8 rounded-md w-full">
                    <div class="flex items-center justify-end pb-6">

                        <div class="flex items-center justify-end">
                            <div class="lg:ml-40 space-x-8">
                                <button
                                        class="bg-indigo-600 px-4 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer"
                                >
                                    New Report
                                </button>
                                <button
                                        class="bg-indigo-600 px-4 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer"
                                >
                                    Create
                                </button>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">
                            <div
                                    class="inline-block min-w-full shadow rounded-lg overflow-hidden"
                            >
                                <table class="min-w-full leading-normal">
                                    <thead>
                                        <tr>
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
                                        </tr>
                                    </thead>
                                    <c:choose>
                                        <c:when test="${promotions != null}">
                                            <tbody>
                                                <c:forEach items="${promotions}" var="promotion">
                                                    <tr>
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
