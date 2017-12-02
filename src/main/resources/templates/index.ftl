<html>

<head>
    <script src="/example/frappe-gantt.min.js"/>
    <script src="/example/moment.min.js"/>
    <script src="/example/snap.svg-min.js"/>
</head>

<script>
    var tasks = [
        {
            id: 'Task 1',
            name: 'Redesign website',
            start: '2016-12-28',
            end: '2016-12-31',
            progress: 20,
            dependencies: 'Task 2, Task 3'
        }
    ]
    var gantt = new Gantt("#gantt", tasks);
</script>
<body>
<svg id="gantt"></svg>

</body>
</html>

