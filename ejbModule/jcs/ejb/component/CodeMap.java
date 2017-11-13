package jcs.ejb.component;

import java.util.HashMap;
import java.util.List;



public class CodeMap {
	private static HashMap<String, String> countryMap = new HashMap<String, String>();
	private static HashMap<String, String> areaMap = new HashMap<String, String>();
	private static HashMap<String, String> villageMap = new HashMap<String, String>();
	
	/**
	 * 傳入DB取得的資料, 轉成 Map. 方便以CountryName取得CountryId
	 * @param countryList: Object[]欄位為CountryId,CountryName
	 * @return
	 */
	public static HashMap<String, String> getCountryMap(List<Object[]> countryList) {
		countryMap.clear();
		// 建置CountryName對照CountryID表
		for (int idx = 0; idx < countryList.size(); idx++) {
			Object[] row = (Object[])countryList.get(idx);
			countryMap.put(String.valueOf(row[1]), String.valueOf(row[0]));
		}
		return countryMap;
	}
	
	/**
	 * 傳入DB取得的資料, 轉成 Map. 方便以CountryId+"-"+AreaName 取得AreaId
	 * @param areaList: Object[]欄位為CountryId,AreaId,AreaName,
	 * @return
	 */
	public static HashMap<String, String> getAreaMap(List<Object[]> areaList) {
		areaMap.clear();
		// 建置CountryId+"-"+AreaName 對照AreaID表
		for (int idx = 0; idx < areaList.size(); idx++) {
			Object[] row = (Object[])areaList.get(idx);
			areaMap.put(String.valueOf(row[0])+"-"+String.valueOf(row[2]), String.valueOf(row[1]));
		}
		return areaMap;
	}

	/**
	 * 傳入DB取得的資料, 轉成 Map. 方便以CountryId+"-"+AreaId+"-"+VillageName 取得AreaId
	 * @param villageList: Object[]欄位為CountryId,AreaId,VillageId,VillageName
	 * @return
	 */
	public static HashMap<String, String> getVillageMap(List<Object[]> villageList) {
		villageMap.clear();
		// 建置CountryId+"-"+AreaName 對照AreaID表
		for (int idx = 0; idx < villageList.size(); idx++) {
			Object[] row = (Object[])villageList.get(idx);
			villageMap.put(String.valueOf(row[0])+"-"+String.valueOf(row[1])+"-"+String.valueOf(row[3]), String.valueOf(row[2]));
		}
		return villageMap;
	}
	
}
