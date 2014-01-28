<%-- 
    Document   : dispositivoXBee
    Created on : 06-25-2013, 10:25:15 PM
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

<script type="text/javascript" language="javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/TableTools.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/dataTables.editor.js"></script>
<script type="text/javascript" src="dataTables.fnReloadAjax.js"></script>
<script type="text/javascript" charset="utf-8" id="init-code">



$(document).ready(function() {
    var oTable = $('#example').dataTable( {
        "bProcessing": true,
        "sAjaxSource": "xbeelist.jsp",
         "bFilter": false,
            "bProcessing": true,
            "bSort": true,
            "bInfo": true,
            "bPaginate": true,
            "sDom": 'Tfrtip',
            "aaSorting": [[ 4, "asc" ]],
            "aoColumns": [
                { "mData": "codigo" },
                { "mData": "xbee" },
                { "mData": "ubicacion" }
            ],
            "oTableTools": {
                "sRowSelect": "single",
                "aButtons": [  ]
            }
    } );
} );
</script>    

<script>
    var oTT;
    var filas;
    $(document).ready(function(){



        $( "#eliminar" )
        .button()
        .click(function() {
            oTT = TableTools.fnGetInstance( 'example' );
            var filas=oTT.fnGetSelectedData();
            if(filas.length == 0){
                alert( 'Seleccione una fila para eliminar' );
            }
            else{
                $( "#eliminar_data" ).modal( 'show' );
            }
        });

        $( "#editar" )
        .button()
        .click(function() {
            oTT = TableTools.fnGetInstance( 'example' );
            filas=oTT.fnGetSelectedData();
            if(filas.length == 0){
                alert( 'Seleccione una fila para editar' );
            }
            else{
                editarUbicacion.value=filas[0].ubicacion;
                editarXbee.value= filas[0].xbee
                
                //xbeeEditar.value=filas[0].xbee_id;
                $( "#editar_data" ).modal( 'show' );
            }

        });

        $( "#agregar" )
        .button()
        .click(function() {
            $('#combo').load('lista.jsp','id=0');  
            $( "#crear_data" ).modal( 'show' );
        });

        $("#agregarInsert").button().click(function(){
            if(agregarXbee.value != ""){
                $.ajax({
                    url: 'insert.jsp',
                    type: 'GET',
                    data:  {id:'xbee',
                        descripcion: agregarUbicacion.value,
                        xbee: agregarXbee.value
                    },
                    complete: function(){
                        var oTable1 = $('#example').dataTable();
                        oTable1.fnReloadAjax();

                    },
                    success: function (){
                        $("#crear_data").hide();
                        agregarUbicacion.value="";
                        agregarXbee.value="";
                    }   
                });
            }
            else{
                alert("Ingrese una descripcion");
            }

        });

        $("#eliminarFila").button().click(function(){
            oTT = TableTools.fnGetInstance( 'example' );
            filas=oTT.fnGetSelectedData();
            $.ajax({
                url: 'delete.jsp',
                type: 'GET',
                data:  {id:'xbee',
                    codigo: filas[0].codigo
                },
                complete: function(){
                    var oTable1 = $('#example').dataTable();
                    oTable1.fnReloadAjax();

                },
                success: function (){
                    $("#eliminar_data").hide();

                }        
            });

        });

        $("#actualizarFila").button().click(function(){
            oTT = TableTools.fnGetInstance( 'example' );
            filas=oTT.fnGetSelectedData();
            if(editarXbee.value != ""){
                $.ajax({
                    url: 'update.jsp',
                    type: 'GET',
                    data:  {id:'xbee',
                        descripcion: editarUbicacion.value,
                        xbee: editarXbee.value,
                        codigo: filas[0].codigo
                    },
                    complete: function(){
                        var oTable1 = $('#example').dataTable();
                        oTable1.fnReloadAjax();

                    },
                    success: function (){
                        $("#editar_data").hide();
                        editarUbicacion.value="";
                        editarXbee.value="";
                    }   
                });
            }
            else{
                alert("Ingrese una descripcion");
            }

        });

    });
</script>

<div id="contentwrapper">
    <div class="main_content"> 
        <h1 class="heading">Dispositovos XBee</h1>
        <div>
            <div class="btn-group">

                <button class="btn" id="agregar" >Agregar</button>
                <button class="btn" id ="editar">Editar</button>
                <button class="btn" id="eliminar" >Eliminar </button>

            </div>
        </div>
        <table cellpadding="0" cellspacing="0" border="0" class="table  table-bordered" id="example" width="100%">
            <thead>
                <tr>
                    <th width="18%">Codigo</th>
                    <th width="25%">XBee</th>
                    <th width="25%">Ubicacion</th>
                </tr>
            </thead>
        </table>
            
    </div>
</div>

<div id="crear_data" title="Agregar Tomacorrientes" class="modal hide">
    <div class="modal-header">
        <button class="close" data-dismiss="modal">×</button>
        <h3>Tomacorrientes</h3>
    </div>
    <div class="modal-body">
        <form>
            <fieldset>
                <label for="name">XBee</label>
                <input type="text" name="agregarXbee" id="agregarXbee"  />
                <label for="name">Ubicacion</label>
                <input type="text" name="agregarUbicacion" id="agregarUbicacion"  />
            </fieldset>
        </form>
    </div>

    <div class="modal-footer">
        <button class="btn" id="agregarInsert" >Agregar</button>
        <a href="#" class="btn" data-dismiss="modal">Cancelar</a>
    </div>      
</div>

<div id="editar_data" title="Editar Tomacorrientes" class="modal hide">
    <div class="modal-header">
        <button class="close" data-dismiss="modal">×</button>
        <h3>XBee</h3>
    </div>
    <div class="modal-body">
        <form>
            <fieldset>
                <label for="name">XBee</label>
                <input type="text" name="editarXbee" id="editarXbee"  />
                <label for="name">Ubicacion</label>
                <input type="text" name="editarUbicacion" id="editarUbicacion"  />
            </fieldset>
        </form>
    </div>

    <div class="modal-footer">
        <button class="btn" id="actualizarFila" >Aceptar</button>
        <a href="#" class="btn" data-dismiss="modal">Cancelar</a>
    </div>      
</div>

<div id="eliminar_data" title="Editar Tomacorrientes" class="modal hide">
    <div class="modal-header">
        <button class="close" data-dismiss="modal">×</button>
        <h3>Tomacorrientes</h3>
    </div>
    <div class="modal-body">
        <p>Esta seguro que desea eliminar este tomacorrientes? </p>
    </div>

    <div class="modal-footer">
        <button class="btn" id="eliminarFila" >Eliminar</button>
        <a href="#" class="btn" data-dismiss="modal">Cancelar</a>
    </div>      
</div>