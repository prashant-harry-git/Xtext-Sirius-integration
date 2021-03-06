package org.eclipse.sirius.example.fowlerdsl.xtextwidget;

import java.util.function.Consumer;

import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.core.api.controllers.AbstractEEFCustomWidgetController;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

public class XtextPartialViewerController extends AbstractEEFCustomWidgetController {

	private Consumer<Object> newValueConsumer;

	public XtextPartialViewerController(EEFCustomWidgetDescription description, IVariableManager variableManager, IInterpreter interpreter,
			EditingContextAdapter contextAdapter) {
		super(description, variableManager, interpreter, contextAdapter);
	}

	@Override
	protected EEFCustomWidgetDescription getDescription() {
		return this.description;
	}

	@Override
	public void refresh() {
		super.refresh();
		this.newEval().call("var:self", this.newValueConsumer);
	}

	public void onNewValue(Consumer<Object> consumer) {
		this.newValueConsumer = consumer;
	}

	public void removeValueConsumer() {
		this.newValueConsumer = null;
	}
}
