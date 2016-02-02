<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

 <!-- Initialize scripts. -->
 <script src="<spring:url value="/WEB-APP/resources/scripts/lib/jquery/jquery-2.1.1.min.js" />"></script>
 <script src="<spring:url value="/WEB-APP/resources/scripts/lib/angularjs/angular.min.js" />"></script>
 <script src="<spring:url value="/WEB-APP/resources/scripts/lib/angularjs/angular-route.min.js" />"></script>
 <script src="<spring:url value="/WEB-APP/resources/scripts/lib/angularjs/angular-sanitize.min.js" />"></script>
 <script src="<spring:url value="/WEB-APP/resources/scripts/lib/angularjs/ng-google-chart.js" />"></script>
 <script src="<spring:url value="/WEB-APP/resources/scripts/lib/bootstrap/js/bootstrap.min.js" />"></script> 
 <script src="<spring:url value="/WEB-APP/resources/scripts/lib/ui-bootstrap/ui-bootstrap-custom-0.12.0.min.js" />"></script>
 <script src="<spring:url value="/WEB-APP/resources/scripts/lib/ui-bootstrap/ui-bootstrap-custom-tpls-0.12.0.min.js" />"></script>
 <script src="<spring:url value="/WEB-APP/resources/scripts/app/app-config.js" />"></script>
 <script src="<spring:url value="/WEB-APP/resources/scripts/app/services/broker.js" />"></script>
 <script src="<spring:url value="/WEB-APP/resources/scripts/app/controllers/page-controller.js" />"></script>

 <!--Global Variables -->
<script type="text/javascript">
   var appBaseUrl = "<spring:url value='/' />";
</script>