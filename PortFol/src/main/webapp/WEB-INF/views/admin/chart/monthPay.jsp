<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>월별 매출</title>
<%@ include file="includeFile.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://cdn.jsdelivr.net/gh/emn178/chartjs-plugin-labels/src/chartjs-plugin-labels.js"></script>
</head>
<style>
    .add{
        width: 700px;
        height: 300px;
        border: 1px solid;
        float: left;
   		}
</style>
<body>
    <div class="add">
        <canvas id="monthPayChart"  style="width: 100%; height: 100%;"></canvas>
    </div>
    <script>
        var ctx = document.getElementById('monthPayChart');
        var myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월',],
                datasets: [{
                    label: '월 수입',
                    data: [123, 200 , 50 , 12, 5 , 250 , 10 , 280 , 150 , 155 , 120 , 280],
                    backgroundColor: [
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    ],
                    borderColor: [
                    'rgba(54, 162, 235, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
            }
        });
    </script>        
</body>
</html>