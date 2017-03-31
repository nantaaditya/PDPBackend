package blibli.ptp.model;

public class SingleBaseResponse<T> extends BaseResponse {

  private T value;

  public SingleBaseResponse() {
  }

  public SingleBaseResponse(int code, String message, String requestId, T value) {
    super(code, requestId, message);
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "SingleBaseResponse{" + "value=" + value + '}';
  }
}
