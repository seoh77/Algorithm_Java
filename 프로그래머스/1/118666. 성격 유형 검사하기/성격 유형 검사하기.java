import java.util.*;

class Solution {
    
    static enum Type {
        R, T, C, F, J, M, A, N;
    }
    
    static HashMap<Type, Integer> map;
    
    public String solution(String[] survey, int[] choices) {
        // 1. 초기화
        init();
    	
        // 2. 점수 계산
    	for(int i=0; i<survey.length; i++) {
    		calScore(survey[i], choices[i]);
    	}
    	
        // 3. 결과 계산
        return decide();
    }
    
    /**
        존재하는 성격 유형에 따라 HashMap 초기화
    */
    public void init() {
        map = new HashMap<Type, Integer>();
    	
    	for(Type type : Type.values()) {
    		map.put(type, 0);
    	}
    }
    
    /**
        설문조사 항목 별로 점수 계산
    */
    public void calScore(String survey, int choices) {
    	if(choices == 4) {
    		return;
    	}
    	
    	int score = 4 - choices;
    	
    	if(score > 0) {
    		add(survey.split("")[0], score);
    	} else {
    		add(survey.split("")[1], Math.abs(score));
    	}
    }
    
    /**
        각 항목에 점수 반영
    */
    public void add(String s, int score) {
    	Type type = Type.valueOf(s);
    	map.replace(type, map.get(type) + score);
    }
    
    /**
        최종 점수에 따라 성격 유형 결정
    */
    public String decide() {
    	String result = "";
    	
    	// 1번 지표
    	if(map.get(Type.R) >= map.get(Type.T)) {
    		result += String.valueOf(Type.R);
    	} else {
    		result += String.valueOf(Type.T);
    	}
    	
    	// 2번 지표
    	if(map.get(Type.C) >= map.get(Type.F)) {
    		result += String.valueOf(Type.C);
    	} else {
    		result += String.valueOf(Type.F);
    	}
    	
    	// 3번 지표
    	if(map.get(Type.J) >= map.get(Type.M)) {
    		result += String.valueOf(Type.J);
    	} else {
    		result += String.valueOf(Type.M);
    	}
    	
    	// 4번 지표
    	if(map.get(Type.A) >= map.get(Type.N)) {
    		result += String.valueOf(Type.A);
    	} else {
    		result += String.valueOf(Type.N);
    	}
    	
    	return result;
    }
}