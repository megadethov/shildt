<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head><title>Using JSTL Functions</title></head>
<body>

<c:set var="str" value="Welcome to javatpoint"/>

<c:if test="${fn:containsIgnoreCase(str, 'javatpoint')}">
    <p>Found javatpoint string<p/>
</c:if>

<c:if test="${fn:containsIgnoreCase(str, 'JAVATPOINT')}">
    <p>Found JAVATPOINT string<p/>
</c:if>

</body>
</html>


