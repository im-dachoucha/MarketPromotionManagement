<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
</head>
<body>
<div class="h-screen md:flex">
    <div
            class="relative overflow-hidden md:flex w-1/2 bg-gradient-to-tr from-blue-800 to-purple-700 i justify-around items-center hidden"
    >
        <div>
            <lottie-player
                    src="https://assets1.lottiefiles.com/packages/lf20_47pyyfcf.json"
                    class="cursor-pointer h-64"
                    speed="1"
                    loop
                    autoplay
            ></lottie-player>
        </div>
        <div
                class="absolute -bottom-32 -left-40 w-80 h-80 border-4 rounded-full border-opacity-30 border-t-8"
        ></div>
        <div
                class="absolute -bottom-40 -left-20 w-80 h-80 border-4 rounded-full border-opacity-30 border-t-8"
        ></div>
        <div
                class="absolute -top-40 -right-0 w-80 h-80 border-4 rounded-full border-opacity-30 border-t-8"
        ></div>
        <div
                class="absolute -top-20 -right-20 w-80 h-80 border-4 rounded-full border-opacity-30 border-t-8"
        ></div>
    </div>
    <div class="flex md:w-1/2 justify-center py-10 items-center bg-white">
        <form class="bg-white" action="${pageContext.request.contextPath}/store-admin-login" method="post">
            <%if (request.getAttribute("login error") != null && (boolean) request.getAttribute("login error")) {%>
            <lottie-player
                    src="https://assets10.lottiefiles.com/packages/lf20_y8t1nosz.json"
                    class="cursor-pointer h-24"
                    speed="1"
                    autoplay
            ></lottie-player>
            <%}%>
            <h1 class="text-gray-800 font-bold text-2xl mb-6">
                Anonymous Market
            </h1>
            <div class="flex items-center border-2 py-2 px-3 rounded-2xl mb-4">
                <svg
                        xmlns="http://www.w3.org/2000/svg"
                        class="h-5 w-5 text-gray-400"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                >
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M16 12a4 4 0 10-8 0 4 4 0 008 0zm0 0v1.5a2.5 2.5 0 005 0V12a9 9 0 10-9 9m4.5-1.206a8.959 8.959 0 01-4.5 1.207"/>
                </svg>
                <input
                        class="pl-2 outline-none border-none"
                        type="email"
                        name="email"
                        placeholder="Email Address"
                />
            </div>
            <div class="flex items-center border-2 py-2 px-3 rounded-2xl">
                <svg
                        xmlns="http://www.w3.org/2000/svg"
                        class="h-5 w-5 text-gray-400"
                        viewBox="0 0 20 20"
                        fill="currentColor"
                >
                    <path
                            fill-rule="evenodd"
                            d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z"
                            clip-rule="evenodd"
                    />
                </svg>
                <input
                        class="pl-2 outline-none border-none"
                        type="password"
                        name="password"
                        placeholder="Password"
                />
            </div>
            <button
                    type="submit"
                    class="block w-full bg-indigo-600 mt-4 py-2 rounded-2xl text-white font-semibold mb-2"
            >
                Log In
            </button>
        </form>
    </div>
</div>
<%-- todo for later usage --%>
<%--<div class="w-screen h-screen flex justify-center items-center--%>
<%--       bg-gradient-to-br from-purple-700 to-amber-700">--%>
<%--    <form class="p-10 bg-white rounded-xl drop-shadow-lg space-y-5"--%>
<%--          action="${pageContext.request.contextPath}/store-admin-login" method="post">--%>
<%--&lt;%&ndash;        <h1 class="text-center text-3xl">Anonymous market</h1>&ndash;%&gt;--%>
<%--        <lottie-player--%>
<%--                src="https://assets1.lottiefiles.com/packages/lf20_czw73gm9.json"--%>
<%--                class="cursor-pointer h-32"--%>
<%--                speed="1"--%>
<%--                loop--%>
<%--                autoplay--%>
<%--        ></lottie-player>--%>

<%--        &lt;%&ndash; alert &ndash;%&gt;--%>
<%--        <%if (request.getAttribute("login error") != null && (boolean) request.getAttribute("login error")) {%>--%>
<%--        <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative" role="alert">--%>
<%--            <strong class="font-bold">Holy smokes!</strong>--%>
<%--            <span class="block sm:inline">Wrong credentials.</span>--%>
<%--            <span class="absolute top-0 bottom-0 right-0 px-4 py-3">--%>
<%--            </span>--%>
<%--        </div>--%>
<%--        <%}%>--%>
<%--        &lt;%&ndash;        &ndash;%&gt;--%>
<%--        <div class="flex flex-col space-y-2">--%>
<%--            <label class="text-sm font-light" for="email">Email</label>--%>
<%--            <input class="w-96 px-3 py-2 rounded-md border border-slate-400" type="email" placeholder="Your Email"--%>
<%--                   name="email" id="email">--%>
<%--        </div>--%>
<%--        <div class="flex flex-col space-y-2">--%>
<%--            <label class="text-sm font-light" for="password">Password</label>--%>
<%--            <input class="w-96 px-3 py-2 rounded-md border border-slate-400" type="password"--%>
<%--                   placeholder="Your Password" name="password" id="password">--%>
<%--        </div>--%>
<%--        <button class="w-full px-10 py-2 bg-blue-600 text-white rounded-md--%>
<%--             hover:bg-blue-500 hover:drop-shadow-md duration-300 ease-in" type="submit">--%>
<%--            Log In--%>
<%--        </button>--%>
<%--    </form>--%>
<%--</div>--%>
</body>
</html>