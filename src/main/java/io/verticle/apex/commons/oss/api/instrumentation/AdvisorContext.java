package io.verticle.apex.commons.oss.api.instrumentation;

/**
 * @author Jens Saade
 */
public interface AdvisorContext {
    Instrumentation getInstrumentationConfig();

    void setInstrumentationConfig(Instrumentation instrumentationConfig);

    String getCorrelationId();

    Advisor getAdvisor();

    void setAdvisor(Advisor advisor);

    Object[] getSignatureTypes();

    void setSignatureTypes(Object[] signatureTypes);

    Object[] getSignatureArgs();

    void setSignatureArgs(Object[] signatureArgs);

    Object getReturnType();

    void setReturnType(Object returnType);

    Object getReturnValue();

    void setReturnValue(Object returnValue);

    Object getInstance();

    void setInstance(Object instance);
}
