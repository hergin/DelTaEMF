package io.github.hergin.delta;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;

import io.github.hergin.delta.model.Param;
import io.github.hergin.delta.patterns.DesignPattern;
import io.github.hergin.delta.ui.DelTaUI;

public class Main {

	public Main() {

		initializePatterns();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}

		DelTaUI theUI = new DelTaUI(patterns);
		JFrame frame = new JFrame();
		frame.getContentPane().add(theUI, BorderLayout.CENTER);
		frame.setSize(975, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("DelTa Model Generator UI");
	}

	List<DesignPattern> patterns;

	public static void main(String[] args) {
		new Main();
	}

	private void initializePatterns() {
		patterns = new ArrayList<>();
		patterns.add(new DesignPattern("Entity Before Relation", "/io/github/hergin/delta/patterns/ER-Mapping.png",
				new ArrayList<Param>() {
					private static final long serialVersionUID = 1L;
					{
						add(new Param("", "", "Metamodels"));
						add(new Param("src", ""));
						add(new Param("trgt", ""));
						add(new Param("", "", "Rule entityMapping"));
						add(new Param("entityMapping", ""));
						add(new Param("sEnt", ""));
						add(new Param("tEnt", ""));
						add(new Param("", "", "Rule relationMapping"));
						add(new Param("relationMapping", ""));
						add(new Param("sEnt2", ""));
						add(new Param("tEnt2", ""));
						add(new Param("rel1", "", "relation sEnt sEnt2"));
						add(new Param("rel2", "", "relation tEnt tEnt2"));
					}
				},
				"<html><b>Summary:</b> Entity before relation pattern is one of the most<br/>commonly used transformation patterns in exogenous transformations to<br/>encode a mapping between two languages. It creates the elements in a<br/>language corresponding to elements from another language and establishes<br/>traceability links between the elements of source and target languages.<br/><br/><b>Application Conditions:</b> The entity before relation pattern is applicable<br/>when we want to translate elements from one metamodel into elements from<br/>another metamodel. <br/><br/><b>Solution:</b> The pattern first maps entities from the source language to the<br/>corresponding target entities in the entityMapping rule, while maintaining a<br/>traceability link between them. Then, relationships of the source language are<br/>mapped to their target language equivalents.<br/><br/><b>Benefits:</b> With the help of traceability links, each element in the target<br/>language has a corresponding element in the source language. This improves<br/>debugging capabilities and error localization.<br/><br/><b>Disadvantages:</b> The pattern has no known disadvantages. However, the<br/>traceability links should be removed after the transformation is applied.<br/><br/><b>Examples:</b> A typical example of entity before relation pattern is in the<br/>transformation from class diagram to relational database diagrams, where, for<br/>example, a class is transformed to a table, an attribute to a column, and the<br/>relation between class and attribute to a relation between table and column.<br/><br/><b>Related patterns:</b> The pattern can be identified as a special case of Phased<br/>Construction, where the phases are, first, the entities and, then, the relations.<br/><br/><b>Variations:</b> The mapping can be done in either many-to-one or one-to-many<br/>with respect to the relation between source and target metamodels.",
				"ERMapping"));
		patterns.add(new DesignPattern("Transitive Closure", "/io/github/hergin/delta/patterns/Transitive-Closure.png",
				new ArrayList<Param>() {
					private static final long serialVersionUID = 1L;
					{
						add(new Param("", "", "Metamodels"));
						add(new Param("mm", ""));
						add(new Param("", "", "Rule immediateRelation"));
						add(new Param("immediateRelation", ""));
						add(new Param("child", ""));
						add(new Param("parent", ""));
						add(new Param("rel1", "", "relation child parent"));
						add(new Param("", "", "Rule recursiveRelation"));
						add(new Param("recursiveRelation", ""));
						add(new Param("ancestor", ""));

					}
				},
				"<html><b>Summary:</b> Transitive closure is a pattern typically used<br/>for analyzing reachability related problems with an in-place transformation.<br/>It generates the intermediate paths between nodes that are not necessarily<br/>directly connected via traceability links.<br/><br/><b>Application Conditions:</b> The transitive closure pattern is applicable<br/>when the metamodels in the domain have a structure that can be considered<br/>as a directed tree.<br/><br/><b>Solution:</b> The pattern operates on a single metamodel. First, the<br/>immediateRelation rule creates a trace element between entities connected<br/>with a relation. It is applied recursively to cover all relations. Then,<br/>the recursiveRelation rule creates trace elements between the node<br/>indirectly connected. That is, if entities child and parent are connected<br/>with a trace, then child and ancestor will also be connected with a trace.<br/>It is also applied recursively to cover all nodes exhaustively.<br/><br/><b>Benefits:</b> Since all the trace elements are created from each element<br/>to all its ancestors, queries relying on this information lookups are optimal.<br/>The resulting model is still valid conforming to its metamodel because trace<br/>links are created outside the scope of the metamodel. There are no side-effects<br/>and both rules are parallelizable.<br/><br/><b>Disadvantages:</b> The application of the pattern creates many trace elements<br/>for single elements which can create a memory overflow when the model is too<br/>large. We need a rule for each type of relation, also for each combination of<br/>entity types, but that can be leveraged if using abstract types defined in the<br/>metamodel (i.e. super types can be used instead of the subtypes).<br/><br/><b>Examples:</b> The transitive closure pattern can be used to find the lowest<br/>common ancestor between two nodes in a directed tree, such as finding all<br/>superclasses of a class in UML class diagram.<br/><br/><b>Related patterns:</b> Transitive closure and fixed-point iteration patterns<br/>can be integrated together to reach a target state in the model structure.<br/><b>Variations:</b> Instead of traces, we can use existing relation types from<br/>the metamodel if allowed. Different types of relations can be used to provide<br/>a priority structure.",
				"TransitiveClosure"));
		patterns.add(
				new DesignPattern("Visitor", "/io/github/hergin/delta/patterns/Visitor.png", new ArrayList<Param>() {
					private static final long serialVersionUID = 1L;
					{
						add(new Param("", "", "Metamodels"));
						add(new Param("mm", ""));
						add(new Param("", "", "Rule markInitEntity"));
						add(new Param("markInitEntity", ""));
						add(new Param("startEnt", ""));
						add(new Param("", "", "Rule visitEntity"));
						add(new Param("visitEntity", ""));
						add(new Param("currentEnt", ""));
						add(new Param("", "", "Rule markNextEntity"));
						add(new Param("markNextEntity", ""));
						add(new Param("currentEnt", ""));
						add(new Param("nextEntity", ""));
						add(new Param("rel1", "", "relation currEnt nextEnt"));
					}
				}, "<html><b>Summary:</b> This pattern traverses all the nodes in a tree and processes<br/>each entity individually.<br/><br/><b>Application Conditions:</b> The pattern can be applied to problems that consist<br/>of (or can be mapped to) a tree structure where all the nodes need to be processed<br/>individually.<br/><br/><b>Solution:</b> The pattern starts by marking an entity with an action tag in the<br/>markInitEntity rule. Then, in the visitEntity rule, the marked entity is tagged as<br/>processed, if it has not been processed yet.<br/>The markNextEntity rule marks the immediate child of the last processed entities as<br/>marked and returns back to the visitEntity rule.<br/>It accomplishes this with a decision relation and fail/success branches. The condition<br/>and action tags appear in the low compartment of the entity.<br/><br/><b>Benefits:</b> The pattern allows for the individual processing of nodes in a<br/>specific order, rather than bulk modification operations of model transformations.<br/>Note that a context can be provided when processing an entity of the metamodel.<br/>The pattern also allows for different model traversal strategies.<br/><br/><b>Disadvantages:</b> A loop helps to traverse the tree structure, therefore the<br/>parallelization of the rules is more difficult.<br/><br/><b>Examples:</b> This pattern can be used to compute the depth level of each class<br/>in a class inheritance hierarchy, which represents its distance from the base class.<br/><br/><b>Related patterns:</b> The pattern is related to phased construction and recursive<br/>descent patterns, when the structure resembles a tree.<br/><br/><b>Variations:</b> The context that is needed to process elements can change. Also,<br/>visitEntity and markNextEntity rules can be NoSched rules with one rule per type<br/>inside to parallelize them. Finally, the ordering of the visit can be adapted to<br/>be depth-first, breadth-first, or custom order.",
						"Visitor"));
	}

}
