package com.jonmid.segundoparcial.parser;

import com.jonmid.segundoparcial.models.TeamModelAnguloJorge;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 17/10/2017.
 */

public class TeamJsonAnguloJorge {

    public static List<TeamModelAnguloJorge> getData(String content) throws JSONException {
        JSONObject jsonObject = new JSONObject(content);
        JSONArray jsonArray = jsonObject.getJSONArray("teams");
        List<TeamModelAnguloJorge> teamModelAnguloJorgeList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject item = jsonArray.getJSONObject(i);

            TeamModelAnguloJorge teamModelAnguloJorge = new TeamModelAnguloJorge();
            teamModelAnguloJorge.setName(item.getString("name"));
            teamModelAnguloJorge.setCode(item.getString("code"));


            teamModelAnguloJorgeList.add(teamModelAnguloJorge);
        }
        return teamModelAnguloJorgeList;
    }


}
