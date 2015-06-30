package org.cantor.flyter;


import org.cantor.flyter.model.response.RoundTripDto;
import org.cantor.flyter.model.response.TripDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class QpxResponseParser {

	public List<RoundTripDto> parseResponse(String jsonResponse) { // todo : delete when Gson will assemble the DTO

		List<RoundTripDto> roundTripsFound = new ArrayList<>();
		JSONParser parser = new JSONParser();

		try {
			JSONObject parentJson = (JSONObject) parser.parse(jsonResponse);

			JSONObject trips = (JSONObject) parentJson.get("trips");

			JSONArray tripResults = (JSONArray) trips.get("tripOption");

			int counter = 0;

			for (Object result : tripResults) {

				RoundTripDto roundTripDto = new RoundTripDto();

				counter++;
				JSONObject resultJSon = (JSONObject) result;

				String tripPrice = (String) resultJSon.get("saleTotal");
				roundTripDto.setTripPrice(tripPrice);

				JSONArray slices = (JSONArray) resultJSon.get("slice");

				TripDto goingTripDto = new TripDto();

				JSONObject goingTripJson = (JSONObject) slices.get(0);

				long goingTripDurationInMinutes = (long) goingTripJson.get("duration");
				goingTripDto.setDurationInHour(goingTripDurationInMinutes);

				JSONArray goingTripSegments = (JSONArray) goingTripJson.get("segment");

				JSONObject firstSegment = (JSONObject) goingTripSegments.get(0);
				JSONArray firstSegmentLegs = (JSONArray) firstSegment.get("leg");
				JSONObject firstSegmentLegInfo = (JSONObject) firstSegmentLegs.get(0);

				String goingTripDepartureTime = (String) firstSegmentLegInfo.get("departureTime");
				goingTripDto.setDepartureTime(goingTripDepartureTime);
				int numberOfStopsInGoingTrip = goingTripSegments.size() - 1;
				goingTripDto.setNumberOfStops(numberOfStopsInGoingTrip);

				TripDto backTripDto = new TripDto();

				JSONObject backTripJson = (JSONObject) slices.get(1);

				long backTripDurationInMinutes = (long) backTripJson.get("duration");
				backTripDto.setDurationInHour(backTripDurationInMinutes);

				JSONArray backTripSegments = (JSONArray) backTripJson.get("segment");

				JSONObject lastSegment = (JSONObject) backTripSegments.get(backTripSegments.size() - 1);
				JSONArray lastSegmentLegs = (JSONArray) lastSegment.get("leg");
				JSONObject lastSegmentLegInfo = (JSONObject) lastSegmentLegs.get(0);

				String backTripArrivalTime = (String) lastSegmentLegInfo.get("arrivalTime");
				backTripDto.setDepartureTime(backTripArrivalTime);
				int numberOfStopsInBackTrip = backTripSegments.size() - 1;
				backTripDto.setNumberOfStops(numberOfStopsInBackTrip);

				roundTripDto.setGoingTrip(goingTripDto);
				roundTripDto.setBackTrip(backTripDto);

				roundTripsFound.add(roundTripDto);
			}

		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		return roundTripsFound;
	}
}
