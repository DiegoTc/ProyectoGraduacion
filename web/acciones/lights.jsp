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
<script type="text/javascript" language="javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/TableTools.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/dataTables.editor.js"></script>
<script type="text/javascript" src="dataTables.fnReloadAjax.js"></script>
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
                { "mData": "switch" }
            ],
            "oTableTools": {
                "sRowSelect": "single",
                "aButtons": [  ]
            },
            aoColumnDefs  : [
                {
                    aTargets: [2],    // Column number which needs to be modified
                    fnRender: function (o, v) {   // o, v contains the object and value for the column
                        return '<span class="checkslide"><input type="checkbox" checked="checked" /><label data-on="ON" data-off="OFF"></label></span>'
                    }
                }]
        } );
    } );
    
    

</script>    


<!DOCTYPE html>
<!-- main content -->
<div id="contentwrapper">
    <div class="main_content"> 
        <h3 class="heading">Luces de la casa</h3>

        <form>

            <table cellpadding="0" cellspacing="0" border="0" class="table table-bordered" id="example" width="100%">
                <thead>
                    <tr>
                        <th width="18%">Codigo</th>
                        <th width="25%">Descripcion</th>
                        <th width="25%">On/Off</th>
                    </tr>
                </thead>
            </table>

            <table class="display data_table3 "  id="data_table3">
                <thead>
                    <tr>
                        <th width="174" >Codigo</th>
                        <th width="246" >Descripcion</th>
                        <th width="199" >On/Off</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox"  id="checkbox1" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox"  />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox"  />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 
                        </td>
                    </tr>
                    <tr>

                        <td  align="left">B ring</td>
                        <td >ring B</td>
                        <td >RD115560</td>
                        <td >
                            <span class="checkslide">
                                <input type="checkbox" checked="checked" />
                                <label data-on="ON" data-off="OFF"></label>
                            </span>
                        </td>
                        <td >
                            <span class="tip" >
                                <a  title="Edit" >
                                    <img src="images/icon/icon_edit.png" >
                                </a>
                            </span> 
                            <span class="tip" >
                                <a id="1" class="Delete"  name="Band ring" title="Delete"  >
                                    <img src="images/icon/icon_delete.png" >
                                </a>
                            </span> 

                        </td>
                    </tr>
                </tbody>
            </table>
        </form>

        <!--tab1-->
        <ul class="uibutton-group">
            <li><a class="uibutton icon add "  title="Add Product">Add Product</a></li>
            <li><a class="uibutton special DeleteAll"  >Delete</a></li>
        </ul>

    </div><!-- End content -->

</div>

<script>
    $('#checkbox1').change(function() {
        if ($(this).is(':checked')) {
            // alert("Hola");
            $.ajax({
                url: 'lightaction.jsp',
                type: 'GET',
                data:  "id=1"
            });
        }
        else
        {
            //alert("Hola Mundo");
            $.ajax({
                url: 'lightaction.jsp',
                type: 'GET',
                data:  "id=0"
            });    
        }
    });
</script>