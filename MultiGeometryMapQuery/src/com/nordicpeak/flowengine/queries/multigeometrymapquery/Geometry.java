package com.nordicpeak.flowengine.queries.multigeometrymapquery;

import java.io.Serializable;
import java.lang.reflect.Field;

import se.unlogic.standardutils.dao.annotations.DAOManaged;
import se.unlogic.standardutils.dao.annotations.Key;
import se.unlogic.standardutils.dao.annotations.ManyToOne;
import se.unlogic.standardutils.dao.annotations.Table;
import se.unlogic.standardutils.reflection.ReflectionUtils;
import se.unlogic.standardutils.xml.GeneratedElementable;
import se.unlogic.standardutils.xml.XMLElement;

@Table(name="multi_geometry_map_query_instance_geometries")
@XMLElement
public class Geometry extends GeneratedElementable implements Serializable {

	private static final long serialVersionUID = -4789836314307395263L;

	public static final Field QUERY_INSTANCE_RELATION = ReflectionUtils.getField(Geometry.class, "queryInstance");
	
	@Key
	@DAOManaged(autoGenerated = true)
	@XMLElement
	private Integer geometryID;

	@DAOManaged
	@XMLElement
	private String config;

	@DAOManaged
	@XMLElement
	private String geometry;

	@DAOManaged(columnName="queryInstanceID")
	@ManyToOne
	@XMLElement
	private MultiGeometryMapQueryInstance queryInstance;

	private com.vividsolutions.jts.geom.Geometry printableGeometry;
	
	public Geometry() { }
	
	public Geometry(String geometry, String config) {
		this.geometry = geometry;
		this.config = config;
	}
	
	public Geometry(String geometry, String config, com.vividsolutions.jts.geom.Geometry printableGeometry) {
		this.geometry = geometry;
		this.config = config;
		this.printableGeometry = printableGeometry;
	}
	
	public Integer getGeometryID() {
		return geometryID;
	}

	public void setGeometryID(Integer geometryID) {
		this.geometryID = geometryID;
	}
	
	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getGeometry() {
		return geometry;
	}

	public void setGeometry(String geometry) {
		this.geometry = geometry;
	}

	public com.vividsolutions.jts.geom.Geometry getPrintableGeometry() {
		return printableGeometry;
	}

	public void setPrintableGeometry(com.vividsolutions.jts.geom.Geometry printableGeometry) {
		this.printableGeometry = printableGeometry;
	}

	public MultiGeometryMapQueryInstance getQueryInstance() {
		return queryInstance;
	}

	public void setQueryInstance(MultiGeometryMapQueryInstance queryInstance) {
		this.queryInstance = queryInstance;
	}

}
