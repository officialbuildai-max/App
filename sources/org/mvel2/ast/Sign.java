package org.mvel2.ast;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: classes7.dex */
public class Sign extends ASTNode {
    private Signer signer;
    private ExecutableStatement stmt;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class BigDecSigner implements Signer {
        private BigDecSigner() {
        }

        @Override // org.mvel2.ast.Sign.Signer
        public Object sign(Object obj) {
            return new BigDecimal(-((BigDecimal) obj).doubleValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class BigIntSigner implements Signer {
        private BigIntSigner() {
        }

        @Override // org.mvel2.ast.Sign.Signer
        public Object sign(Object obj) {
            return new BigInteger(String.valueOf(-((BigInteger) obj).longValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class DoubleSigner implements Signer {
        private DoubleSigner() {
        }

        @Override // org.mvel2.ast.Sign.Signer
        public Object sign(Object obj) {
            return Double.valueOf(-((Double) obj).doubleValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class FloatSigner implements Signer {
        private FloatSigner() {
        }

        @Override // org.mvel2.ast.Sign.Signer
        public Object sign(Object obj) {
            return Float.valueOf(-((Float) obj).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class IntegerSigner implements Signer {
        private IntegerSigner() {
        }

        @Override // org.mvel2.ast.Sign.Signer
        public Object sign(Object obj) {
            return Integer.valueOf(-((Integer) obj).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class LongSigner implements Signer {
        private LongSigner() {
        }

        @Override // org.mvel2.ast.Sign.Signer
        public Object sign(Object obj) {
            return Long.valueOf(-((Long) obj).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class ShortSigner implements Signer {
        private ShortSigner() {
        }

        @Override // org.mvel2.ast.Sign.Signer
        public Object sign(Object obj) {
            return Integer.valueOf(-((Short) obj).shortValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface Signer extends Serializable {
        Object sign(Object obj);
    }

    public Sign(char[] cArr, int i11, int i12, int i13, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        int i14 = i11 + 1;
        this.start = i14;
        int i15 = i12 - 1;
        this.offset = i15;
        this.fields = i13;
        if ((i13 & 16) != 0) {
            ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, i14, i15, parserContext);
            this.stmt = executableStatement;
            Class knownEgressType = executableStatement.getKnownEgressType();
            this.egressType = knownEgressType;
            if (knownEgressType == null || knownEgressType == Object.class) {
                return;
            }
            initSigner(knownEgressType);
        }
    }

    private void initSigner(Class cls) {
        Class f11 = m.f(cls);
        if (Integer.class.isAssignableFrom(f11)) {
            this.signer = new IntegerSigner();
            return;
        }
        if (Double.class.isAssignableFrom(f11)) {
            this.signer = new DoubleSigner();
            return;
        }
        if (Long.class.isAssignableFrom(f11)) {
            this.signer = new LongSigner();
            return;
        }
        if (Float.class.isAssignableFrom(f11)) {
            this.signer = new FloatSigner();
            return;
        }
        if (Short.class.isAssignableFrom(f11)) {
            this.signer = new ShortSigner();
            return;
        }
        if (BigInteger.class.isAssignableFrom(f11)) {
            this.signer = new BigIntSigner();
        } else {
            if (BigDecimal.class.isAssignableFrom(f11)) {
                this.signer = new BigDecSigner();
                return;
            }
            throw new CompileException("illegal use of '-': cannot be applied to: " + f11.getName(), this.expr, this.start);
        }
    }

    private Object sign(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.signer == null) {
            Class cls = this.egressType;
            if (cls == null || cls == Object.class) {
                this.egressType = obj.getClass();
            }
            initSigner(this.egressType);
        }
        return this.signer.sign(obj);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return sign(org.mvel2.d.q(this.expr, this.start, this.offset, obj2, variableResolverFactory));
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return sign(this.stmt.getValue(obj, obj2, variableResolverFactory));
    }

    public ExecutableStatement getStatement() {
        return this.stmt;
    }

    @Override // org.mvel2.ast.ASTNode
    public boolean isIdentifier() {
        return false;
    }
}
