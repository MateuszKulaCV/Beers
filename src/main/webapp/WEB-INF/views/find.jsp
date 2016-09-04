
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <script >
var temp=[];

</script>
</head> 
<body>

<div class="container" id="searchable-container">
<div class="row">
<div class="col-lg-4 col-lg-offset-4">
            <input type="search" id="container-search" value="" class="form-control" placeholder="Search...">
     	</div>
		</div>
<div class="panel-group" id="accordion">

<c:forEach items="${beerList}" var="out">
	 <div class="panel panel-default">
      <div class="panel-heading">
       		 <h4 class="panel-title">
       		 
       		 <script>
       		 $(function() {
       			 temp.push("${out.piwo}");
       		
       		 })
       		 </script>
       		 
    		 <img src="${out.link}" height="50" width="50"/>
         	 <a data-toggle="collapse" data-parent="#accordion" href="#${out.id}">${out.piwo}</a>
        	 </h4>
      </div>
      
      
      </div>
      </c:forEach>
      </div>
      </div>
               <script>
                     $(function () {
                    	$('#container-search').autocomplete({
                    		source: temp,
                    		select: function(event,ui){
                    			$('#container-search').val(ui.item.label);
                    		
                    		},
                    		onSelect: function(event,ui){
                    			$('#container-search').val(ui.item.label);
                    		}
                    		
                    	})
   						
                    	    $( '#searchable-container' ).searchable({
                    	        searchField: '#container-search',
                    	        selector: '.panel',
                    	        childSelector: '.panel-heading',
                    	        show: function( elem ) {
                    	            elem.slideDown(100);
                    	          
                    	        },
                    	        hide: function( elem ) {
                    	            elem.slideUp( 100 );
                    	        }
                    	    })
                    	});
    </script>
           <!-- beerlist.piwo -> podpowiedzi
           		beerlist.link + piwo -> wynik -->
</body>
</html>