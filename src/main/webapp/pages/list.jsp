<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<html>
<head>
    <title>List</title>
    <%@include file="../common/resource.jsp"%>
</head>
<body>
<%@include file="../common/sidebar.jsp"%>
<div class="content bg-gray-100">
    <div class="content-heading flex items-center justify-between p-[20px]">
        <div class="content-heading-title">
            <h3 class="font-medium text-xl">Product Management</h3>
        </div>
        <div class="content-heading-breadcrumb">
            <ul class="flex items-center text-xs gap-[4px]">
                <li><a href="#">Home </a></li>
                <li> > </li>
                <li><a href="#" class="active"> Product Management</a></li>
            </ul>
        </div>
    </div>
    <div class="container-fluid flex">
        <div class="content-body bg-white m-[20px] w-[100%] mt-[0] mx-[30px]">
            <div class="flex flex-columns">
                <button class="p-[12px] m-[12px] border hover:bg-[#f5f5f5]"><a href="/create">Create new employees</a></button>
            </div>
            <table class="m-[20px] mt-[0] w-[97%]">
                <tr class="text-left pl-[20px] h-[52px]">
                    <th class="w-[40px] font-normal">ID</th>
                    <th class="text-left w-[300px] font-normal">Product Name</th>
                    <th class="w-[200px] font-normal">Price</th>
                    <th class="w-[300px] font-normal">Action</th>
                </tr>
                <c:forEach var="item" items="${products}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>
                            <ul class="flex gap-[20px] items-center">
                                <li><button class="hover:text-[#27a9e3]"><a href="/product?id=${item.id}">Details</a></button></li>
                                <li><button class="hover:text-[#27a9e3]"><a href="/update?id=${item.id}">Edit</a></button></li>
                                <li>
                                    <button class="hover:text-[#27a9e3]" type="submit"><a href="/delete?id=${item.id}">Delete</a></button>
                                </li>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
