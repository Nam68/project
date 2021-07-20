package trip.path.temp;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import trip.map.model.CartDTO;
import trip.planInfo.model.PlanInfoVO;

@Controller
public class GoogleController {
	
	private ArrayList<CallMapDTO> arr2;

	//시작고정
	@RequestMapping(value = "/calculateDistance.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ModelAndView mapList(Model model, HttpSession session, int day) {
		HashMap<Integer, Object> cart = (HashMap<Integer, Object>) session.getAttribute("placeCart");
		ArrayList<CartDTO> dayList = (ArrayList<CartDTO>) cart.get(day);

		LocationDistance dis = new LocationDistance();

		arr2 = new ArrayList<CallMapDTO>();
		for (int i = 0; i < dayList.size(); i++) {
			for (int j = 0; j < dayList.size(); j++) {
				if (!dayList.get(i).getPl_name().equals(dayList.get(j).getPl_name())) {
					CallMapDTO dto = new CallMapDTO(dayList.get(i).getPl_idx(), dayList.get(j).getPl_idx(),
							dis.distance(dayList.get(i).getPl_lat(), dayList.get(i).getPl_lng(),
									dayList.get(j).getPl_lat(), dayList.get(j).getPl_lng(), "meter"));
					arr2.add(dto);
				}

			}

		}

		int solt[] = new int[dayList.size()];
		solt[0] = dayList.get(0).getPl_idx();

		for (int i = 1; i < solt.length; i++) {

			int end = 0;
			double min = 99999999;

			for (int j = 0; j < arr2.size(); j++) {

				int count = 0;

				for (int z = 0; z < solt.length; z++) {
					if (solt[z] != 0 && solt[z] == arr2.get(j).getEnd()) {
						count++;
					}
				}

				// System.out.println(list.get(j).getEnd().equals(see[i]));
				if (min > arr2.get(j).getDuration() && arr2.get(j).getStart() == solt[i - 1] && count == 0) {

					min = arr2.get(j).getDuration();
					end = arr2.get(j).getEnd();
				}
			}
			solt[i] = end;
		}

		ArrayList<CartDTO> newCart = new ArrayList<CartDTO>();
		for (int i = 0; i < solt.length; i++) {
			for (int j = 0; j < dayList.size(); j++) {
				if (solt[i] == dayList.get(j).getPl_idx()) {
					newCart.add(dayList.get(j));
				}
			}
		}
		cart.put(day, newCart);

		ArrayList<MapDTO> list = google(newCart);

		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = "";
		try {
			jsonStr = mapper.writeValueAsString(newCart);

			// System.out.println(jsonStr);

			model.addAttribute("json", jsonStr);

			session.setAttribute("cartmap", jsonStr);
			session.setAttribute("mapcost", list);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("placeCart", newCart);
		mav.addObject("mapcost", list);
		mav.setViewName("tripJson");
		return mav;
	}

	// 구글 거리 반환
	public ArrayList<MapDTO> google(ArrayList<CartDTO> arr) {
		ArrayList<MapDTO> list = new ArrayList<MapDTO>();

		for (int i = 0; i < arr.size(); i++) {
			if (i + 1 == arr.size()) {
				break;
			} else {
				String json;
				try {
					json = JsonParseTest.JsonText(arr.get(i).getPl_lat() + "," + arr.get(i).getPl_lng(),
							arr.get(i + 1).getPl_lat() + "," + arr.get(i + 1).getPl_lng());
					String[] arr1 = json.split("value");
					int duration = Integer.parseInt(arr1[1].substring(arr1[1].indexOf(":") + 1, arr1[1].indexOf("}")));
					int distance = Integer.parseInt(arr1[2].substring(arr1[2].indexOf(":") + 1, arr1[2].indexOf("}")));

					MapDTO dto = new MapDTO(arr.get(i).getPl_idx(), arr.get(i + 1).getPl_idx(), duration, distance);

					list.add(dto);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					for (int j = 0; j < arr2.size(); j++) {
						if (arr.get(i).getPl_idx() == arr2.get(j).getStart()
								&& arr.get(i + 1).getPl_idx() == arr2.get(j).getEnd()) {


							int distance = (int) arr2.get(j).getDuration();
							int duration = distance / 3;

							MapDTO dto = new MapDTO(arr.get(i).getPl_idx(), arr.get(i + 1).getPl_idx(), duration,
									distance);
							list.add(dto);
						}
					}

				}

			}

		}

		return list;
	}

	
	/*
	// 시작, 끝고정
	public String ListTest(Model model, String map[]) throws InterruptedException {

		ArrayList<PlaceDTO> arr = new ArrayList<PlaceDTO>();

		for (int i = 0; i < map.length; i++) {
			PlaceDTO dto = ps.placeSelect(map[i]);
			arr.add(dto);
		}

		LocationDistance dis = new LocationDistance();

		ArrayList<CallMapDTO> arr2 = new ArrayList<CallMapDTO>();
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.size(); j++) {
				if (!arr.get(i).getPl_name().equals(arr.get(j).getPl_name())) {
					CallMapDTO dto = new CallMapDTO(arr.get(i).getPl_name(), arr.get(j).getPl_name(),
							dis.distance(arr.get(i).getPl_lat(), arr.get(i).getPl_lng(), arr.get(j).getPl_lat(),
									arr.get(j).getPl_lng(), "meter"));
					System.out
							.println("시작: " + dto.getStart() + ", 도착: " + dto.getEnd() + ", 거리: " + dto.getDuration());
					arr2.add(dto);
				}

			}

		}

		String solt[] = new String[map.length];
		solt[0] = map[0];
		solt[1] = map[map.length - 1];

		for (int i = 2; i < solt.length; i++) {

			String end = "";
			double min = 99999999;

			if (i % 2 == 1) {
				for (int j = 0; j < arr2.size(); j++) {

					int count = 0;

					for (int z = 0; z < solt.length; z++) {
						if (solt[z] != null && solt[z].equals(arr2.get(j).getEnd())) {
							count++;
						}
					}

					// System.out.println(list.get(j).getEnd().equals(see[i]));
					if (min > arr2.get(j).getDuration() && arr2.get(j).getStart().equals(solt[i - 2]) && count == 0) {

						min = arr2.get(j).getDuration();
						end = arr2.get(j).getEnd();

						System.out.println("끝부터 " + min + ", " + end);
						// Thread.sleep(2000);
					}
				}

			}

			else {
				for (int j = 0; j < arr2.size(); j++) {

					int count = 0;

					for (int z = 0; z < solt.length; z++) {
						if (solt[z] != null && solt[z].equals(arr2.get(j).getEnd())) {
							count++;
						}
					}

					// System.out.println(list.get(j).getEnd().equals(see[i]));
					if (min > arr2.get(j).getDuration() && arr2.get(j).getStart().equals(solt[i - 2]) && count == 0) {

						min = arr2.get(j).getDuration();
						end = arr2.get(j).getEnd();

						System.out.println("시작부터 " + solt[i - 2] + ": " + min + ", " + end);
						// Thread.sleep(2000);
					}
				}
			}

			solt[i] = end;

		}

		String[] so = new String[solt.length];
		so[0] = solt[0];
		int co = 1;
		int co2 = 1;
		for (int i = 1; i < solt.length; i++) {
			if (i % 2 == 1) {
				so[solt.length - co] = solt[i];
				co++;
			} else {
				so[co2] = solt[i];
				co2++;
			}

		}
		System.out.println("solu:");
		for (int i = 0; i < solt.length; i++) {
			System.out.println(solt[i]);
		}
		System.out.println("so");
		for (int i = 0; i < solt.length; i++) {
			System.out.println(so[i]);
		}

		return "map/MapList";
	}
	*/

}
