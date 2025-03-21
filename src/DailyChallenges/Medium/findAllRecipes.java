package DailyChallenges.Medium;

import java.util.*;
import java.util.stream.Collectors;

//Problem-2115
public class findAllRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans=new ArrayList<>();
        Set<String> suppliesSet=new HashSet<>();
        for(String supply:supplies){
            suppliesSet.add(supply);
        }
        Map<String, List<String>> graph=new HashMap<>();
        Map<String,Integer> inDegree=new HashMap<>();

        //BuildGraph
        for(int i=0;i<recipes.length;++i){
            for(String ingredient:ingredients.get(i)){
                if(!suppliesSet.contains(ingredient)){
                    graph.putIfAbsent(ingredient,new ArrayList<>());
                    graph.get(ingredient).add(recipes[i]);
                    inDegree.merge(recipes[i],1,Integer::sum);
                }
            }
        }
        Queue<String> q= Arrays.stream(recipes).filter(recipe->inDegree.getOrDefault(recipe,0)==0).collect(Collectors.toCollection(ArrayDeque::new));
        while(!q.isEmpty()){
            String u=q.poll();
            ans.add(u);
            if(!graph.containsKey(u)){
                continue;
            }
            for(String v:graph.get(u)){
                inDegree.merge(v,-1,Integer::sum);
                if(inDegree.get(v)==0){
                    q.offer(v);
                }
            }
        }
        return ans;
    }
}
