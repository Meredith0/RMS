<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link href="bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
	</head>

	<body>
		<div class="container">
			<form action="" class="form-horizontal" role="form">

				<legend>Test</legend>

				<div class="form-group">
					<label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>
					<div class="input-group date form_date col-md-5" data-date="" data-date-format="yy MM dd" data-link-field="dtp_input2"
					 data-link-format="yyyy-mm-dd">
						<input class="form-control" size="16" type="text" value="" readonly>
						<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
						<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
					</div>
					<input type="hidden" id="dtp_input2" value="" /><br />
				</div>

			</form>
		</div>

		<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script src="js/bootstrap-datetimepicker.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$('.form_date').datetimepicker({
				format: 'yyyy-mm-dd',
				language: 'zh-CN',
				startDate: "2013-02-14",
				weekStart: 1,
				todayBtn: 1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				minView: 2,
				forceParse: 0,
			});
		</script>

	</body>
</html>
