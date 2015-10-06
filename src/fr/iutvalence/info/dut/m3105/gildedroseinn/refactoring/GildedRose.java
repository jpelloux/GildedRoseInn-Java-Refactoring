package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{
	
	private static final int	MAX_QUALITY	= 50;
	private static List<Item>	items		= null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
		
		newDay();
		
		for (Item currentItem : items)
			System.out.println(currentItem);
	}
	
	private static void newDay()
	{
		for (Item currentItem : items)
		{
			if (isLegendary(currentItem))
				continue;
			
			decreaseSellIn(currentItem);
			updateQuality(currentItem);
		}
	}
	
	public static void updateQuality(Item currentItem)
	{
		switch (currentItem.getName())
		{
			case "Aged Brie":
				processAgedBrie(currentItem);
				break;
			
			case "Backstage passes to a TAFKAL80ETC concert":
				processBackstage(currentItem);
				break;
			
			case "Conjured Mana Cake":
				processConjuredItem(currentItem);
				break;
			
			default:
				processDefault(currentItem);
				break;
		
		}
	}
	
	private static void processConjuredItem(Item currentItem)
	{
		processDefault(currentItem);
		processDefault(currentItem);
	}
	
	private static boolean isLegendary(Item currentItem)
	{
		return currentItem.getName().equals("Sulfuras, Hand of Ragnaros");
	}
	
	private static void processDefault(Item currentItem)
	{
		decreaseQuality(currentItem);
		if (isPassedOut(currentItem))
		{
			decreaseQuality(currentItem);
		}
	}
	
	private static void processBackstage(Item currentItem)
	{
		increaseQuality(currentItem);
		
		if (currentItem.getSellIn() <= 10)
		{
			increaseQuality(currentItem);
		}
		
		if (currentItem.getSellIn() <= 5)
		{
			increaseQuality(currentItem);
		}
				
		if (isPassedOut(currentItem))
		{
			currentItem.setQuality(0);
		} 

		
	}
	
	private static void processAgedBrie(Item currentItem)
	{
		increaseQuality(currentItem);
		if (isPassedOut(currentItem))
		{
			increaseQuality(currentItem);
		}
	}
	
	private static boolean isPassedOut(Item currentItem)
	{
		return currentItem.getSellIn() < 0;
	}
	
	private static void decreaseQuality(Item currentItem)
	{
		if (currentItem.getQuality() > 0)
		{
			currentItem.setQuality(currentItem.getQuality() - 1);
		}
	}
	
	private static void increaseQuality(Item currentItem)
	{
		if (currentItem.getQuality() < MAX_QUALITY)
		{
			currentItem.setQuality(currentItem.getQuality() + 1);
		}
	}
	
	private static void decreaseSellIn(Item currentItem)
	{
		currentItem.setSellIn(currentItem.getSellIn() - 1);
	}
	
}
