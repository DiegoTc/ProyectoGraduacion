<%-- 
Document   : lights
Created on : 04-27-2013, 09:19:46 PM
Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<style type="text/css" title="currentStyle">
    @import "../css/jquery.dataTables.css";
    @import "../css/TableTools.css";
    @import "../css/dataTables.editor.css";

    #container {
        padding-top: 60px !important;
        width: 960px !important;
    }
    #dt_example .big {
        font-size: 1.3em;
        line-height: 1.45em;
        color: #111;
        margin-left: -10px;
        margin-right: -10px;
        font-weight: normal;
    }
    #dt_example {
        font: 95%/1.45em "Lucida Grande", Verdana, Arial, Helvetica, sans-serif;
        color: #111;
    }
    div.dataTables_wrapper, table {
        font: 13px/1.45em "Lucida Grande", Verdana, Arial, Helvetica, sans-serif;
    }
    #dt_example h1 {
        font-size: 16px !important;
        color: #111;
    }
    #footer {
        line-height: 1.45em;
    }
    div.examples {
        padding-top: 1em !important;
    }
    div.examples ul {
        padding-top: 1em !important;
        padding-left: 1em !important;
        color: #111;
    } 

</style>


<!DOCTYPE html>
<!-- main content -->
<div id="contentwrapper">
    <div class="main_content"> 
        <h3 class="heading">Luces de la casa</h3>


        <div>
            <div class="btn-group">

                <button class="btn" id="actualizar" >Actualizar</button>

            </div>
        </div>
        <table cellpadding="0" cellspacing="0" border="0" class="table table-bordered" id="example" width="100%">
            <thead>
                <tr>
                    <th width="18%">Codigo</th>
                    <th width="25%">Descripcion</th>
                    <th width="25%">On/Off</th>
                    <th width="25%">ID</th>
                </tr>
            </thead>
        </table>



    </div><!-- End content -->

</div>

<script type="text/javascript" language="javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/TableTools.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/dataTables.editor.js"></script>
<script type="text/javascript" src="../dispositivos/dataTables.fnReloadAjax.js"></script>
<script type="text/javascript" charset="utf-8" id="init-code">
    
    
   

    $(document).ready(function() {
        var oTable = $('#example').dataTable( {
            "bProcessing": true,
            "sAjaxSource": "switchlights.jsp",
            "bFilter": false,
            "bProcessing": true,
            "bSort": true,
            "bInfo": true,
            "bPaginate": true,
            "sDom": 'Tfrtip',
            "aaSorting": [[ 4, "asc" ]],
            "aoColumns": [
                { "mData": "codigo" },
                { "mData": "descripcion" },
                { "mData": "xbee_id"},
                { "mData": "switch" }
                
                
            ],
            "oTableTools": {
                "sRowSelect": "single",
                "aButtons": [  ]
            },
            aoColumnDefs  : [
                {
                    aTargets: [3],    // Column number which needs to be modified
                    fnRender: function (o, v) {   // o, v contains the object and value for the column
                        return '<span class="checkslide"><input type="checkbox" checked="false" /><label data-on="ON" data-off="OFF"></label></span>'
                    }
                },
                { "bVisible": false, "aTargets": [2] }
            ]
        } );
        
         var che, cheVal = new Array();
          $( "#actualizar" ).button().click(function() {
        $.getJSON( "lightaction.jsp", function( data ) {
            
            var i=0;
            var idLight="id"+oTable.fnGetData(i).codigo;
            che = $("input[type=checkbox]");
            
            $.each( data, function( key, val ) {
               if(key==idLight){
                   if(val== 0){
                       che.get(i).checked=false;
                   }
                   else{
                       che.get(i).checked=true;
                   }
                   i++;
                   idLight="id"+oTable.fnGetData(i).codigo;
               }
               
               
            });
 
            
            
        });
    });

        

    } );
    
    var checked, checkedValues = new Array();
    $(document).on("change", "input[type=checkbox]", function(e) {
        
        
        checked = $("input[type=checkbox]:checked");
        checkedValues = checked.map(function(i) { return $(this).val() }).get();
        var oTable = TableTools.fnGetInstance( 'example' );
        var filas=oTable.fnGetSelectedData();
        if ($(this).is(':checked')) {
            var idLight="id"+filas[0].codigo;
            $.ajax({
                url: 'lightaction.jsp',
                type: 'GET',
                data:  "id="+idLight+"action="+1,
                success: alert("Hola")
            });
        }
        else
        {
             var idLight="id"+filas[0].codigo;
            $.ajax({
                url: 'lightaction.jsp',
                type: 'GET',
                data:  "id="+idLight+"action="+0,
                success: alert("Hola2")
            });    
        }
    });
    

</script>    
