package datastructure;

interface LinkedList<E> {

    // 처음에 추가
    void addFirst(E value);
    // 마지막에 추가
    void add(E value);
    // 특정 위치에 추가
    void add(E value, int idx);

    // 처음에서 제거
    E removeFirst();
    // 끝에서 제거
    E removeLast();
    // 특정 원소 (처음 등장한) 제거
    boolean remove(Object value);
    // 특정 위치에서 제거
    E remove(int idx);

    // 특정 위치 조회
    E get(int idx);
    // 특정 위치의 값 수정
    void set(E value, int idx);

    // 리스트에 원소가 존재하는지
    boolean contains(Object value);
    // 리스트에서 원소의 위치
    int indexOf(Object value);

    // 리스트의 사이즈
    int size();
    // 리스트가 비어있는지
    boolean isEmpty();
    // 리스트 초기화
    void clear();
    // 리스트 출력
    void print();
}
