<%-- 
    Document   : Statistique
    Created on : 26 janv. 2024, 08:03:25
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.*, java.util.*" %>
<%
    String username = (String)session.getAttribute("username");
    Vector<V_statistique> stat = (Vector<V_statistique>) request.getAttribute("stat");
    double totalHomme=0;
    double totalFemme=0;
    for(int i=0;i<stat.size();i++)
    {
        totalHomme+=stat.get(i).getHomme();
        totalFemme+=stat.get(i).getFemme();
    }
    double total=totalHomme+totalFemme;
    double prHomme=(totalHomme/total)*100;
    double prFemme=(totalFemme/total)*100;
%>

<%@ include file="header.jsp" %>
<script src="<%=request.getContextPath() %>/assets/vendor/chart.js/chart.min.js"></script>

<main>
    <section class="section">
            <div class="container">
                    <div class="row justify-content-center" style="background-color:whitesmoke;border-color:whitesmoke ">
                            <div class="col-lg-8" style="margin-top: 100px;">
                                    <div class="card mb-3">
                                            <div class="card-body">
                                                <table class="table">
                                                    <tr>
                                                            <th>Meuble</th>
                                                            <th>Homme</th>
                                                            <th>Femme</th>

                                                    </tr>
                                                    <% for (int i = 0; i < stat.size(); i++) { %>
                                                    <tr>

                                                            <td> <%= stat.get(i).getNom()%></td>
                                                            <td> <%= stat.get(i).getHomme()%></td>
                                                            <td> <%= stat.get(i).getFemme()%></td>

                                                    </tr>

                                                        <% } %>
                                                </table>
                                                
                                                <!-- Pie Chart -->
                          <!-- Pie Chart -->
<canvas id="pieChart" style="max-height: 400px;"></canvas>
<script>
  document.addEventListener("DOMContentLoaded", () => {
    new Chart(document.getElementById('pieChart'), {
      type: 'pie',
      data: {
        labels: [
          'Femme',
          'Homme'
        ],
        datasets: [{
          label: 'My First Dataset',
          data: [<%= prFemme %>, <%=prHomme %>],
          backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(54, 162, 235)'
          ],
          hoverOffset: 4
        }]
      }
    });
  });
</script>

          
           
              <!-- End Pie CHart -->
                                                
                                                
                                            </div>
                                    </div> 
                            </div>
                    </div>
            </div>
    </section>
</main>                                                        
                                                        
<%@ include file="footer.jsp" %>
