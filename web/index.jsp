<%-- 
    Document   : index
    Created on : 04-27-2013, 07:02:22 PM
    Author     : diego
--%>


<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
       <div id="contentwrapper">
                <div class="main_content"> 
                    <div class="row-fluid">
						<div class="span12">
							<h3 class="heading">User Profile</h3>
							<div class="row-fluid">
								<div class="span8">
									<form class="form-horizontal">
										<fieldset>
											<div class="control-group formSep">
												<label class="control-label">Username</label>
												<div class="controls text_line">
													<strong>peraltas</strong>
												</div>
											</div>
											<div class="control-group formSep">
												<label for="fileinput" class="control-label">User avatar</label>
												<div class="controls">
													<div data-provides="fileupload" class="fileupload fileupload-new">
														<input type="hidden" />
														<div style="width: 80px; height: 80px;" class="fileupload-new thumbnail"><img src="img/gCons/male-user.png" alt="" /></div>
														<div style="width: 80px; height: 80px; line-height: 80px;" class="fileupload-preview fileupload-exists thumbnail"></div>
														<span class="btn btn-file"><span class="fileupload-new">Select image</span><span class="fileupload-exists">Change</span><input type="file" id="fileinput" name="fileinput" /></span>
														<a data-dismiss="fileupload" class="btn fileupload-exists" href="#">Remove</a>
													</div>	
												</div>
											</div>
											<div class="control-group formSep">
												<label for="u_fname" class="control-label">Full name</label>
												<div class="controls">
													<input type="text" id="u_fname" class="input-xlarge" value="John Smith" />
												</div>
											</div>
											<div class="control-group formSep">
												<label for="u_email" class="control-label">Email</label>
												<div class="controls">
													<input type="text" id="u_email" class="input-xlarge" value="serpel.js@gmail.com" />
												</div>
											</div>
											<div class="control-group formSep">
												<label for="u_password" class="control-label">Password</label>
												<div class="controls">
													<div class="sepH_b">
														<input type="password" id="u_password" class="input-xlarge" />
														<span class="help-block">Enter your password</span>
													</div>
													<input type="password" id="s_password_re" class="input-xlarge" />
													<span class="help-block">Repeat password</span>
												</div>
											</div>
                                                       <div class="control-group formSep">
                                                            <div class="controls">
                                                                 <button class="btn btn-gebo" type="submit">Connect with facebook</button>
                                                            </div>
                                                       </div>
											<div class="control-group formSep">
												<label class="control-label">I want to receive:</label>
												<div class="controls">
													<label class="checkbox inline">
														<input type="checkbox" value="sys_messages" id="email_sysmessages" name="email_receive" checked="checked" />
														Email Notifications
													</label>
													<label class="checkbox inline">
														<input type="checkbox" value="other_messages" id="email_othermessages" name="email_receive" />
														Facebook Publications
													</label>
												</div>
											</div>											
											<div class="control-group">
												<div class="controls">
													<button class="btn btn-gebo" type="submit">Save changes</button>
                                                                 <button class="btn">Cancel</button>
												</div>
											</div>
										</fieldset>
									</form>
								</div>
							</div>
						</div>
					</div>
                        
                </div>
            </div>