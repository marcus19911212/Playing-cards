package com.itheima.doudizhu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * 模拟斗地主发牌
		需求分析：
			买牌
			洗牌
			发牌
			看牌
 */
public class DouDiZhu {
	public static void main(String[] args) {
		// 牌的花色
		String[] color = { "♥", "♠", "♦", "♣" };
		// 牌的数字
		String[] number = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		// 创建有序集合 存储索引
		ArrayList<Integer> indexList = new ArrayList<>();
		/*
		 * 大王 小王 红桃2 黑桃2 方片2 梅花2 A K Q J 10 9 8 7 6 5 4 3
		 * 0   1   2   3    4   5
		 */
		// 创建map集合,用于存储有序的牌:键值对
		Map<Integer, String> cardsMap = new HashMap<>();
		// 添加键值对
		int count=2;
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < color.length; j++) {
				cardsMap.put(count, color[j]+number[i]);
				indexList.add(count);
				count++;
			}
		}
		//添加大小王
		cardsMap.put(0, "大王");
		indexList.add(0);
		cardsMap.put(1, "小王");
		indexList.add(1);
		System.out.println(cardsMap);
		//洗牌
		Collections.shuffle(indexList);
		System.out.println(indexList);
		//发牌
		ArrayList<Integer> person1 = new ArrayList<>();
		ArrayList<Integer> person2 = new ArrayList<>();
		ArrayList<Integer> person3 = new ArrayList<>();
		ArrayList<Integer> finalCards = new ArrayList<>();
		
		for (int i = 0; i < indexList.size(); i++) {
			if(i<3){
				finalCards.add(indexList.get(i));
			}else if(i%3==0){
				person1.add(indexList.get(i));
			}else if(i%3==1){
				person2.add(indexList.get(i));
			}else if(i%3==2){
				person3.add(indexList.get(i));
			}
				
		}
		//看牌
		glanceCards(cardsMap, person1, person2, person3, finalCards);
		//排序
		methodSort(cardsMap, person1, person2, person3, finalCards);
		

	}

	public static void glanceCards(Map<Integer, String> cardsMap, ArrayList<Integer> person1,
			ArrayList<Integer> person2, ArrayList<Integer> person3, ArrayList<Integer> finalCards) {
		System.out.print("person1手中的牌:");
		for (int j = 0; j < person1.size(); j++) {
			System.out.print(cardsMap.get(person1.get(j))+" ");
		}
		System.out.println();
		System.out.print("person2手中的牌:");
		for (int j = 0; j < person2.size(); j++) {
			System.out.print(cardsMap.get(person2.get(j))+" ");
		}
		System.out.println();
		System.out.print("person3手中的牌:");
		for (int j = 0; j < person3.size(); j++) {
			System.out.print(cardsMap.get(person3.get(j))+" ");
		}
		System.out.println();
		System.out.print("finalCards手中的牌:");
		for (int j = 0; j < finalCards.size(); j++) {
			System.out.print(cardsMap.get(finalCards.get(j))+" ");
		}
		System.out.println();
		System.out.println();
	}

	public static void methodSort(Map<Integer, String> cardsMap, ArrayList<Integer> person1, ArrayList<Integer> person2,
			ArrayList<Integer> person3, ArrayList<Integer> finalCards) {
		Collections.sort(person1);
		Collections.sort(person2);
		Collections.sort(person3);
		Collections.sort(finalCards);
		System.out.print("person1手中的牌:");
		for (int j = 0; j < person1.size(); j++) {
			System.out.print(cardsMap.get(person1.get(j))+" ");
		}
		System.out.println();
		System.out.print("person2手中的牌:");
		for (int j = 0; j < person2.size(); j++) {
			System.out.print(cardsMap.get(person2.get(j))+" ");
		}
		System.out.println();
		System.out.print("person3手中的牌:");
		for (int j = 0; j < person3.size(); j++) {
			System.out.print(cardsMap.get(person3.get(j))+" ");
		}
		System.out.println();
		System.out.print("finalCards手中的牌:");
		for (int j = 0; j < finalCards.size(); j++) {
			System.out.print(cardsMap.get(finalCards.get(j))+" ");
		}
	}
}
