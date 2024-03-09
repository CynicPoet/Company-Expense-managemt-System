<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body class="h-screen w-screen p-0 m-0 flex justify-center items-center bg-zinc-50">
    <!-- Main-Window -->
    <div class="h-full w-10/12 bg-slate-50 shadow-xl">
        <!-- Header -->
        <div class="h-2/12 p-6 w-full flex justify-between items-center">
            <h1 class="text-xl font-semibold">Dashboard</h1>
            <h1 class="text-xl text-blue-600 font-semibold">Employer's Window</h1>
        </div>
        <!-- End Header -->
        <!-- Hero-Section -->
        <div class="flex">
            <div class="w-3/12 h-full">
                <div class="w-11/12 mt-32 h-fit m-5 p-4 rounded-md">
                    <h1 class="text-2xl font-semibold">Welcome,</h1>
                    <h1 class="text-2xl font-semibold tracking-tight text-red-400">Mr. Varun Balbudhe</h1>
                </div>
                <h1 class="pl-7 text-slate-700 font-semibold text-xl">Personal Information</h1>
                <div class="w-11/12 h-fit m-5 p-4 bg-slate-200 rounded-lg">
                    <h1 class="text-lg tracking-tight font-semibold text-zinc-800 mb-1">Username :</h1>
                    <h1 class="text-lg tracking-tight font-semibold text-zinc-800 mb-1">Email-ID :</h1>
                    <h1 class="text-lg tracking-tight font-semibold text-zinc-800 mb-1">Unique-ID :</h1>
                    <h1 class="text-lg tracking-tight font-semibold text-zinc-800 mb-1">Position :</h1>
                </div>
                <h1 class="pl-7 text-slate-700 font-semibold text-xl">Request Information</h1>
                <div class="w-11/12 h-fit m-5 p-4 bg-slate-200 rounded-lg">
                    <h1 class="text-lg tracking-tight font-semibold text-zinc-800 mb-1">Request-Id :</h1>
                    <h1 class="text-lg tracking-tight font-semibold text-zinc-800 mb-1">Status :</h1>
                </div>
                <div class="w-full flex gap-5 justify-center items-center">
                    <div class="font-semibold text-lg bg-blue-400 rounded-md px-3 py-1 cursor-pointer">Generate Request</div>
                </div>
            </div>
            <div class="w-9/12 flex justify-center items-center mt-32">
                <div class="w-11/12 h-full flex justify-center items-center">
                    <div class="w-10/12 h-fit bg-zinc-200 p-4 rounded-md">
                        <h1 class="font-semibold text-xl pl-10 text-zinc-800">Request Id:</h1>
                        <h1 class="font-semibold text-xl pl-10 text-zinc-800">Date: </h1>
                        <h1 class="font-semibold text-xl pl-10 text-zinc-800">Amount</h1>
                        <h1 class="font-semibold text-xl pl-10 text-zinc-800">Description:</h1>
                        <h1 class="font-semibold text-xl pl-10 text-zinc-800">Status:</h1>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Hero-Section -->
    </div>
    <!-- End Main-Window -->
</body>
</html>