package pl.projectE.inject;

class InvocationWithWrongParameterException extends RuntimeException {
    InvocationWithWrongParameterException() {
        super();
    }

    InvocationWithWrongParameterException(String message) {
        super(message);
    }
}
