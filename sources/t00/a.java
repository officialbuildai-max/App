package t00;

import android.support.v4.media.session.c;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.h;
import org.apache.tools.ant.types.m;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    static /* synthetic */ Class f76086e;

    /* renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f76087f;

    /* renamed from: g, reason: collision with root package name */
    static /* synthetic */ Class f76088g;

    /* renamed from: a, reason: collision with root package name */
    public Reader f76089a;

    /* renamed from: b, reason: collision with root package name */
    public int f76090b = 8192;

    /* renamed from: c, reason: collision with root package name */
    public Vector f76091c = new Vector();

    /* renamed from: d, reason: collision with root package name */
    private Project f76092d = null;

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private void f(Object obj) {
        Project project = this.f76092d;
        if (project == null) {
            return;
        }
        if (obj instanceof s00.a) {
            ((s00.a) obj).b(project);
        } else {
            project.K(obj);
        }
    }

    public Reader b() {
        Class<?> cls;
        Reader reader = this.f76089a;
        if (reader == null) {
            throw new BuildException("primaryReader must not be null.");
        }
        int size = this.f76091c.size();
        Vector vector = new Vector();
        for (int i11 = 0; i11 < size; i11++) {
            Vector e11 = ((h) this.f76091c.elementAt(i11)).e();
            int size2 = e11.size();
            for (int i12 = 0; i12 < size2; i12++) {
                vector.addElement(e11.elementAt(i12));
            }
        }
        int size3 = vector.size();
        if (size3 > 0) {
            for (int i13 = 0; i13 < size3; i13++) {
                if (vector.elementAt(i13) instanceof org.apache.tools.ant.types.a) {
                    org.apache.tools.ant.types.a aVar = (org.apache.tools.ant.types.a) vector.elementAt(i13);
                    String e12 = aVar.e();
                    m f11 = aVar.f();
                    Project project = aVar.getProject();
                    if (e12 == null) {
                        continue;
                    } else {
                        if (f11 == null) {
                            try {
                                cls = Class.forName(e12);
                            } catch (ClassNotFoundException e13) {
                                throw new BuildException(e13);
                            } catch (IllegalAccessException e14) {
                                throw new BuildException(e14);
                            } catch (InstantiationException e15) {
                                throw new BuildException(e15);
                            } catch (InvocationTargetException e16) {
                                throw new BuildException(e16);
                            }
                        } else {
                            cls = Class.forName(e12, true, project.g(f11));
                        }
                        if (cls != null) {
                            Class cls2 = f76086e;
                            if (cls2 == null) {
                                cls2 = a("java.io.FilterReader");
                                f76086e = cls2;
                            }
                            if (!cls2.isAssignableFrom(cls)) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append(e12);
                                stringBuffer.append(" does not extend java.io.FilterReader");
                                throw new BuildException(stringBuffer.toString());
                            }
                            Constructor<?>[] constructors = cls.getConstructors();
                            for (int i14 = 0; i14 < constructors.length; i14++) {
                                Class<?>[] parameterTypes = constructors[i14].getParameterTypes();
                                if (parameterTypes.length == 1) {
                                    Class<?> cls3 = parameterTypes[0];
                                    Class<?> cls4 = f76087f;
                                    if (cls4 == null) {
                                        cls4 = a("java.io.Reader");
                                        f76087f = cls4;
                                    }
                                    if (cls3.isAssignableFrom(cls4)) {
                                        reader = (Reader) constructors[i14].newInstance(reader);
                                        f(reader);
                                        Class cls5 = f76088g;
                                        if (cls5 == null) {
                                            cls5 = a("org.apache.tools.ant.types.Parameterizable");
                                            f76088g = cls5;
                                        }
                                        if (cls5.isAssignableFrom(cls)) {
                                            aVar.g();
                                            c.a(reader);
                                            throw null;
                                        }
                                    }
                                }
                            }
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(e12);
                            stringBuffer2.append(" does not define a public constructor");
                            stringBuffer2.append(" that takes in a Reader as its ");
                            stringBuffer2.append("single argument.");
                            throw new BuildException(stringBuffer2.toString());
                        }
                        continue;
                    }
                }
            }
        }
        return reader;
    }

    public void c(Vector vector) {
        this.f76091c = vector;
    }

    public void d(Reader reader) {
        this.f76089a = reader;
    }

    public void e(Project project) {
        this.f76092d = project;
    }
}
