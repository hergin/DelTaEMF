package io.github.hergin.delta;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.WorkflowEngine;
import org.eclipse.emf.mwe.core.WorkflowFacade;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.emf.mwe.utils.Reader;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.expression.ResourceManagerDefaultImpl;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;

public class XPandRunner {

	public static void main(String[] args) throws FileNotFoundException {

		// StandaloneSetup setup = new StandaloneSetup();
		// setup.setPlatformUri("..");
		//
		// Reader reader = new Reader();
		// reader.setUri(URI.createFileURI("src/designpattern/ERMapping.xmi").toString());
		// reader.setModelSlot("model");
		//
		// DirectoryCleaner cleaner = new DirectoryCleaner();
		// cleaner.cleanFolder("src-gen");
		//
		// Generator generator = new Generator();
		// generator.addMetaModel(new EmfRegistryMetaModel());
		// generator.setExpand("template::delta2grgen::main FOR model");
		// ResourceManagerDefaultImpl resMan = new ResourceManagerDefaultImpl();
		// resMan.setFileEncoding("ISO-8859-1");
		// generator.setResourceManager(resMan);
		// Outlet outlet = new Outlet("src-gen");
		// outlet.addPostprocessor(new JavaBeautifier());
		// generator.addOutlet(outlet);
		//
		// GlobalVarDef varDef = new GlobalVarDef();
		// varDef.setName("currentPattern");
		// varDef.setValue("ERMapping");
		// generator.addGlobalVarDef(varDef);

		WorkflowEngine engine = new WorkflowEngine();

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("pattern", "ERMapping");

		engine.run(URI.createFileURI("src/workflow/grgen-dynamic.mwe").toFileString(), new NullProgressMonitor(),
				params, new HashMap<String, Object>());

	}

}