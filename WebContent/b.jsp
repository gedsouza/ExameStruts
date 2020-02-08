<div class="app-content content">
			<div class="content-wrapper">
				<div class="content-header row"></div>
				<div class="content-body">
					<!--Recent Orders & Monthly Salse -->
					<div class="row match-height">
						<div class="col-xl-16 col-lg-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Quantidade de Exames <s:property value="quantidadeExames" /></h4>
									<a class="heading-elements-toggle"><i
										class="fa fa-ellipsis-v font-medium-3"></i></a>
									<div class="heading-elements">
										<ul class="list-inline mb-0">
											<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
											<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
										</ul>
									</div>
								</div>
								<div class="card-content">
									<div class="table-responsive">
										<table id="recent-orders"
											class="table table-hover mb-0 ps-container ps-theme-default">
											<thead>
												<tr>
													<th>Nome</th>
													<th>CPF</th>
													<th>Telefone</th>
													<th>Endereço</th>
													<th>Email</th>
													<th>Exame</th>
													<th>Data</th>
													<th>Situação</th>
												</tr>
											</thead>
											<tbody>
												<s:iterator value="exames">
												<tr>
													<s:form novalidate="true" theme="simple"
														action="listaExames" namespace="/Exames">
														<td><s:property value="nome" /></td>
														<td><s:property value="cpf" /></td>
														<td><s:property value="telefone" /></td>
														<td><s:property value="endereco" /></td>
														<td><s:property value="email" /></td>
														<td><s:property value="tpExame" /></td>
														<td><s:property value="data" /></td>
														<td><s:property value="situacao" /></td>
													</s:form>
												</tr>
											</s:iterator>          
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
				</div>
			</div>
		</div>