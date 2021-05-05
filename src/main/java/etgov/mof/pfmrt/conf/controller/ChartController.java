/*
 * package etgov.mof.pfmrt.conf.controller;
 * 
 * 
 * import java.util.ArrayList; import java.util.HashMap; import java.util.List;
 * import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * import com.google.gson.JsonArray; import com.google.gson.JsonObject;
 * 
 * 
 * @Controller public class ChartController {
 * 
 * @Autowired DataDAO dataDAO;
 * 
 * @Autowired MultipleDataDAO multipleDataDAO;
 * 
 * @Autowired PieChartDAO piechartDAO;
 * 
 * @RequestMapping("/index") public String showHome(){ return "index"; }
 * 
 * 
 * 
 * 
 * @RequestMapping("/linechartdata")
 * 
 * @ResponseBody public String getDataFromDB(){ List<Data> dataList =
 * dataDAO.findAll(); JsonArray jsonMonth = new JsonArray(); JsonArray
 * jsonSubscribers = new JsonArray(); JsonObject json = new JsonObject();
 * dataList.forEach(data->{ jsonMonth.add(data.getMonth());
 * jsonSubscribers.add(data.getSubscribers()); }); json.add("month", jsonMonth);
 * json.add("subscribers", jsonSubscribers); return json.toString(); }
 * 
 * 
 * 
 * @RequestMapping("/multiplelinechart")
 * 
 * @ResponseBody public ResponseEntity<?> getDataForMultipleLine() {
 * List<MultipleData> dataList = multipleDataDAO.findAll(); Map<String,
 * List<MultipleData>> mappedData = new HashMap<>(); for(MultipleData data :
 * dataList) {
 * 
 * if(mappedData.containsKey(data.getName())) {
 * mappedData.get(data.getName()).add(data); }else { List<MultipleData> tempList
 * = new ArrayList<MultipleData>(); tempList.add(data);
 * mappedData.put(data.getName(), tempList); }
 * 
 * } return new ResponseEntity<>(mappedData, HttpStatus.OK); }
 * 
 * @RequestMapping("/piechart") public ResponseEntity<?> getDataForPiechart(){
 * List<PieChartData> piechartData = piechartDAO.findAll(); return new
 * ResponseEntity<>(piechartData, HttpStatus.OK); }
 * 
 * }
 */