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
		
		System.out.println("OMGHAI!");
		
		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
		
		for (int currentItem = 0; currentItem < items.size(); currentItem++)
			System.out.println(items.get(currentItem));
		
		decreaseSellIn();
		updateQuality();
		
		for (int currentItem = 0; currentItem < items.size(); currentItem++)
			System.out.println(items.get(currentItem));
	}
	
	public static void updateQuality()
	{
		for (int currentItem = 0; currentItem < items.size(); currentItem++)
		{
			
			if (("Aged Brie".equals(items.get(currentItem).getName()))
					|| "Backstage passes to a TAFKAL80ETC concert".equals(items
							.get(currentItem).getName()))
			{
				increaseQuality(currentItem);
				
				if ("Backstage passes to a TAFKAL80ETC concert".equals(items
						.get(currentItem).getName()))
				{
					if (items.get(currentItem).getSellIn() <= 10)
					{
						increaseQuality(currentItem);
					}
					
					if (items.get(currentItem).getSellIn() <= 5)
					{
						increaseQuality(currentItem);
					}
				}
				
			} else
			{
				decreaseQuality(currentItem);
			}
			
			// SELLIN PASSEE
			if (items.get(currentItem).getSellIn() < 0)
			{
				if ("Aged Brie".equals(items.get(currentItem).getName()))
				{
					increaseQuality(currentItem);
				} else
				{
					if ("Backstage passes to a TAFKAL80ETC concert"
							.equals(items.get(currentItem).getName()))
					{
						items.get(currentItem).setQuality(0);
					} else
					{
						decreaseQuality(currentItem);
						
					}
					
				}
			}
		}
	}
	
	private static void decreaseQuality(int currentItem)
	{
		if (items.get(currentItem).getQuality() > 0)
		{
			if (!"Sulfuras, Hand of Ragnaros".equals(items.get(currentItem)
					.getName()))
			{
				items.get(currentItem).setQuality(
						items.get(currentItem).getQuality() - 1);
			}
		}
	}
	
	private static void increaseQuality(int currentItem)
	{
		if (items.get(currentItem).getQuality() < MAX_QUALITY)
		{
			items.get(currentItem).setQuality(
					items.get(currentItem).getQuality() + 1);
		}
	}
	
	private static void decreaseSellIn()
	{
		for (int currentItem = 0; currentItem < items.size(); currentItem++)
		
		{
			
			if (!"Sulfuras, Hand of Ragnaros".equals(items.get(currentItem)
					.getName()))
			{
				items.get(currentItem).setSellIn(
						items.get(currentItem).getSellIn() - 1);
			}
		}
	}
	
}
