package j10;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.mvel2.ast.LineLabel;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private int f65829b = 0;

    /* renamed from: a, reason: collision with root package name */
    private Map f65828a = new HashMap();

    public int a(LineLabel lineLabel, VariableResolverFactory variableResolverFactory, CompiledExpression compiledExpression) {
        if (this.f65829b == 1 || b(lineLabel)) {
            throw new RuntimeException("no debugger registered to handle breakpoint");
        }
        return 0;
    }

    public boolean b(LineLabel lineLabel) {
        return this.f65828a.containsKey(lineLabel.getSourceFile()) && ((Set) this.f65828a.get(lineLabel.getSourceFile())).contains(Integer.valueOf(lineLabel.getLineNumber()));
    }
}
