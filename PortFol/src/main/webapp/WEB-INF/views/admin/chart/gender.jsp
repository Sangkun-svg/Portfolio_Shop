<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>남여 성비 그래프</title>
<%@ include file="includeFile.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://cdn.jsdelivr.net/gh/emn178/chartjs-plugin-labels/src/chartjs-plugin-labels.js"></script>
<canvas id="gender" width="=50px" height="50px"></canvas>
</head>
    <script>
        var ctx = document.getElementById('gender');
        var myChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ['남','여'],
                datasets: [{
                    label: '# of Votes',
                    data: [${M},${G}],
                    backgroundColor: [
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 99, 132, 0.2)',
                    ],
                    borderColor: [
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 99, 132, 1)',
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
            }
        });
    </script>
<body>

</body>
</html>