package com.ims.dao;

import java.util.List;

import com.ims.pojo.Category;
import com.ims.pojo.SubCat;

public interface SubCatDao {
	void subcat_list (List<SubCat> scList);
	List<SubCat> add_subcat(List<SubCat> scList, List<Category> categoryList);
	List<SubCat> edit_subcat(List<SubCat> scList, List<Category> categoryList);
	List<SubCat> dlt_subcat (List<SubCat> scList);

}
