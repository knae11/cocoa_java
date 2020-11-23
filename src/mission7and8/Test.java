package mission7and8;

import java.awt.*;
import java.awt.event.*;

// 자바의 정석 80pg 예제 코드 개인해석

// 기본상속관계 : Component <- Window <- Frame
class Test extends Frame implements MouseMotionListener {
    int x = 0;
    int y = 0;
    Image img = null;
    Graphics gImg = null;

    public static void main(String[] args) {
        // instance를 생성하여 메서드를 호출하지 않고 진행 -> 생성자 부분에서 함수를 호출한다.
        // main 메서드가 아래 부분들 보다 위에 있어도 작동하는 이유? : static 메서드이기 때문인듯..!
        new Test("GraphicsEx5");
    }

    public Test(String title) {
        // super을 타고 들어가면 Frame을 상속받기 때문에 init이라는 메서드가 있다. 프레임을 초기화 함수.
        // Frame f = new Frame(title); 의 역할을 해준다고 생각했다. 그렇기 때문에 frame이 나타나서 보이게 되는 것!
        super(title);
        // this.addMouseMotionListener(this)와 동일하게 작동한다. 생략과 매개변수로 this가 들어가는 것은 Event의 사용을 더 알아보면 좋을 듯!
        // this는 test의 this(인스턴스)인데 이것은 frame을 상속한 것이니까 frame의 요소도 포함되어 있는 것이다~!
        // 이벤트를 등록! 이벤트에 따라 인터페이스 구현 메서드가 진행됨! 메서드 내부) mouseMotionListener = AWTEventMulticaster.add(mouseMotionListener,l);
        addMouseMotionListener(this);
        //시스템을 종료하는 event와 핸들러를 등록한 것! Adapter를 사용하여 필요한 메서드만 구현!
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Frame (100, 100) width 500, height 500 . 을 의 위치에 크기로 보이게 한다. 절대위치 지정 : setBounds
        // 얘네들을 타고 들어가면 Window 메서드들!!이다. Window(Frame의 조상) <- Frame 이므로 super에서 받은 test가 window의 메서드를 호출!
        setBounds(100, 100, 500, 500);
        setVisible(true);

        // 새로운 객체 생성!
        // createImage는 Component의 메서드!
        img = createImage(500, 500);
        // img 객체의 getGraphics
        gImg = img.getGraphics();
        gImg.drawString(" .", 10, 50);
        // Component의 메서드! AWT쓰레드는 GUI어플리케이션을 실행하면 자동적으로 생성되는 데몬 쓰레드다.
        // 평소에는 대기상태에 있다가 화면이 갱신되어야 하면 paint 또는 update를 호출 (repaint => update => paint를 호출)
        repaint();
    }

    // Component의 메서드! override이다! frame이 만들어 지기만 하면(init) AWT 쓰레드에서 자동호출된다고 한다. (80pg 참고)
    // 함수를 호출하지 않아도 그려졌던 이유!!!
    public void paint(Graphics g) {
        if(img==null) return;
        g.drawImage(img,0,0,this); // Frame 가상화면에 그려진 그림을 에 복사
    }

    // interface - MouseMotionListener의 구현
    public void mouseMoved(MouseEvent me) {
        x = me.getX();
        y = me.getY();
    }

    // interface - MouseMotionListener의 구현
    public void mouseDragged(MouseEvent me) {
        if (me.getModifiersEx()!=MouseEvent.BUTTON1_DOWN_MASK ) return;
        gImg.drawLine(x,y, me.getX(),me.getY());
        x = me.getX();
        y = me.getY();
        repaint();
    }
}


