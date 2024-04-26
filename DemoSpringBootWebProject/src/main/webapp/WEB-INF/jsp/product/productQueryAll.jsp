<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Product Query All</title>
            <link rel="stylesheet" href="/css/ordersystem.css">
            <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
            <script>
                var indexPage = 1;

                $(function () {
                    loadPage(indexPage);
                });

                function change(page) {
                    indexPage = page;
                    loadPage(indexPage);
                }

                function loadPage(indexPage) {
                    $.ajax({
                        type: 'get',
                        url: '/product/queryByPage/' + indexPage,
                        contentType: 'application/json',
                        success: function (data) {
                            $('#showproduct').empty("");

                            if (data == null) {
                                $('table').prepend('<tr><td>no result</td></tr>');
                            } else {
                                var table = $('#showproduct');
                                table.append("<tr id='ptitle'>" + "<th>ID</th><th>Product Name</th><th>Price</th><th>Date</th><th>Note</th>");

                                $.each(data, function (i, n) {
                                    var tr = "<tr><td>" + n.id + "</td><td>" + n.pname + "</td><td>" + n.price + "</td><td>" + n.pdate + "</td><td>" + n.note + "</td></tr>";
                                    table.append(tr);
                                });
                            }
                        }
                    });
                }
            </script>
        </head>

        <body>
            <div id="productListTitle">Product Query All</div>
            <table id="showproduct" border="1"></table>
            <table id="showpage">
                <tr>
                    <td>Total Pages: ${totalPages} totalRecords: ${totalElements}</td>
                    <td colspan="3" align="right">Previous
                        <c:forEach var="i" begin="1" end="${totalPages}" step="1">
                            <button id="myPage" type="button" onclick="change(${i})">${i}</button>
                        </c:forEach>Next
                    </td>
                </tr>
            </table>
        </body>

        </html>