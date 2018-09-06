package org.sonar.samples.java.background;

import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.sonar.api.Plugin;
import org.sonar.api.batch.bootstrap.ProjectDefinition;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputComponent;
import org.sonar.api.batch.fs.InputDir;
import org.sonar.api.batch.fs.InputModule;
import org.sonar.api.batch.fs.InputPath;
import org.sonar.api.batch.fs.internal.DefaultTextPointer;
import org.sonar.api.batch.fs.internal.DefaultTextRange;
import org.sonar.api.batch.measure.Metric;
import org.sonar.api.batch.measure.MetricFinder;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

//import it.unimib.disco.essere.main.InterfaceModel;



public class MySensor implements Sensor{
	private FileSystem fs;
	private BackWork workspace;
	
	
	
	
	
	
	public MySensor(FileSystem fs) throws Exception {
		
		this.fs = fs;
		
		
		
		
		
	}
	public String getBaseDir() {

		return fs.baseDir().getAbsolutePath();
	}



	
	@Override
	public void describe(SensorDescriptor arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void execute(SensorContext arg0) {
		// TODO Auto-generated method stub
		//LOGGER.info("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		System.out.println("3333333333333333333333333333333333");
		
		
		
	}

	
	
}