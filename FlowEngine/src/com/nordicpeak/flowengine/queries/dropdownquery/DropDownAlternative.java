package com.nordicpeak.flowengine.queries.dropdownquery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import se.unlogic.standardutils.annotations.WebPopulate;
import se.unlogic.standardutils.dao.annotations.DAOManaged;
import se.unlogic.standardutils.dao.annotations.Key;
import se.unlogic.standardutils.dao.annotations.ManyToOne;
import se.unlogic.standardutils.dao.annotations.OneToMany;
import se.unlogic.standardutils.dao.annotations.OrderBy;
import se.unlogic.standardutils.dao.annotations.Table;
import se.unlogic.standardutils.populators.IntegerPopulator;
import se.unlogic.standardutils.populators.PositiveStringIntegerPopulator;
import se.unlogic.standardutils.populators.StringPopulator;
import se.unlogic.standardutils.validation.ValidationError;
import se.unlogic.standardutils.validation.ValidationException;
import se.unlogic.standardutils.xml.GeneratedElementable;
import se.unlogic.standardutils.xml.XMLElement;
import se.unlogic.standardutils.xml.XMLParser;
import se.unlogic.standardutils.xml.XMLValidationUtils;

import com.nordicpeak.flowengine.interfaces.MutableAlternative;

@Table(name = "drop_down_query_alternatives")
@XMLElement
public class DropDownAlternative extends GeneratedElementable implements MutableAlternative, Serializable {

	private static final long serialVersionUID = 5698552791580194144L;

	@DAOManaged(autoGenerated = true)
	@Key
	@XMLElement
	private Integer alternativeID;

	@DAOManaged
	@WebPopulate(required=true,maxLength=255)
	@XMLElement
	private String name;

	@DAOManaged
	@OrderBy
	@XMLElement
	private Integer sortIndex;

	@DAOManaged(columnName="queryID")
	@ManyToOne
	@XMLElement
	private DropDownQuery query;

	@DAOManaged
	@OneToMany
	@XMLElement
	private List<DropDownQueryInstance> instances;

	public DropDownAlternative(){}

	public DropDownAlternative(String name, Integer sortIndex) {

		super();
		this.name = name;
		this.sortIndex = sortIndex;
	}

	public Integer getAlternativeID() {

		return alternativeID;
	}

	public void setAlternativeID(Integer alternativeID) {

		this.alternativeID = alternativeID;
	}

	public DropDownQuery getQuery() {

		return query;
	}

	public void setQuery(DropDownQuery query) {

		this.query = query;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Integer getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

	public List<DropDownQueryInstance> getInstances() {

		return instances;
	}


	public void setInstances(List<DropDownQueryInstance> instances) {

		this.instances = instances;
	}

	@Override
	public String toString() {

		return name + " (alternativeID: " + alternativeID + ")";
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternativeID == null) ? 0 : alternativeID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(getClass() != obj.getClass()){
			return false;
		}
		DropDownAlternative other = (DropDownAlternative)obj;
		if(alternativeID == null){
			if(other.alternativeID != null){
				return false;
			}
		}else if(!alternativeID.equals(other.alternativeID)){
			return false;
		}
		return true;
	}

	@Override
	public void populate(XMLParser xmlParser) throws ValidationException {

		List<ValidationError> errors = new ArrayList<ValidationError>();
		
		alternativeID = XMLValidationUtils.validateParameter("alternativeID", xmlParser, true, PositiveStringIntegerPopulator.getPopulator(), errors);
		name = XMLValidationUtils.validateParameter("name", xmlParser, true, 1, 255, StringPopulator.getPopulator(), errors);
		sortIndex = XMLValidationUtils.validateParameter("sortIndex", xmlParser, true, 1, 255, IntegerPopulator.getPopulator(), errors);
		
		if(!errors.isEmpty()){

			throw new ValidationException(errors);
		}
		
	}

}