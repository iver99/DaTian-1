 <%@ page pageEncoding="UTF-8"%>
 <hr class="hr_2" />
                    <span id="mgmt_nav_switch4a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch4a();">统计分析</span>
                    <span id="mgmt_nav_switch4b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch4b();">统计分析</span>
                    <div id="mgmt_nav4" class="div_mgmt_show1">
                    <% if((Integer)session.getAttribute("userKind") ==3) {%>
                        <a href="getTransportAccuracyPage" class="a_mgmt_leftnav" hidefocus="true">运营指标</a>
                    <% } %>
                        <a href="getFinancialInfoPage" class="a_mgmt_leftnav" hidefocus="true">财务指标</a>
                    </div> 