import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import java.util.HashMap;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.util.ArrayList;








public class SjakkGui extends Application {

	Rectangle rectangleChessBoard;
	private final int HEIGHT = 800;
	private final int WIDTH = 800;
	boolean white = true;
	public Rectangle chessBoard[][] = new Rectangle[9][9]; // = {{1,2},{1,2}};
	private String squareNumber[][];
	ArrayList<ImageView> whiteBricks = new ArrayList<ImageView>();
	ArrayList<ImageView> blackBricks = new ArrayList<ImageView>();
   ImageView currentPiece;
    Rectangle rute;

	public void start(Stage primaryStage) {

      	
	
		/* File sourceimage = new File("ChessPiece/Black_Bishop.png");
        BufferedImage b_bishop = ImageIO.read(sourceimage);
      
        catch (Exception e) {
        	System.out.println("Error");
        } */ 

         Image b_bishop = new Image("Black_Bishop.png");
         Image b_king 	= new Image("Black_King.png");
         Image b_knight = new Image("Black_Knight.png");
         Image b_pawn   = new Image("Black_Pawn.png");
         Image b_queen  = new Image("Black_Queen.png");
         Image b_rook   = new Image("Black_Rook.png"); 

         Image w_bishop = new Image("White_Bishop.png"); 
         Image w_king   = new Image("White_King.png");
         Image w_knight = new Image("White_Knight.png");
         Image w_pawn   = new Image("White_Pawn.png");
         Image w_queen  = new Image("White_Queen.png");
         Image w_rook   = new Image("White_Rook.png");    


         // Black 

         // Pawn
         ImageView b_pawn_img1 = new ImageView();
         b_pawn_img1.setImage(b_pawn);	
          ImageView b_pawn_img2 = new ImageView();
         b_pawn_img2.setImage(b_pawn);
         ImageView b_pawn_img3 = new ImageView();
         b_pawn_img3.setImage(b_pawn);	
          ImageView b_pawn_img4 = new ImageView();
         b_pawn_img4.setImage(b_pawn);
         ImageView b_pawn_img5 = new ImageView();
         b_pawn_img5.setImage(b_pawn);	
          ImageView b_pawn_img6 = new ImageView();
         b_pawn_img6.setImage(b_pawn);
          ImageView b_pawn_img7 = new ImageView();
         b_pawn_img7.setImage(b_pawn);	
          ImageView b_pawn_img8 = new ImageView();
         b_pawn_img8.setImage(b_pawn);
         

         // Rooks 
         ImageView b_bishop_img1 = new ImageView();
         b_bishop_img1.setImage(b_bishop); 
         ImageView b_knight_img1 = new ImageView();
         b_knight_img1.setImage(b_knight);
         ImageView b_rook_img1 = new ImageView();
         b_rook_img1.setImage(b_rook); 

         ImageView b_bishop_img2 = new ImageView();
         b_bishop_img2.setImage(b_bishop); 
         ImageView b_knight_img2 = new ImageView();
         b_knight_img2.setImage(b_knight);
         ImageView b_rook_img2 = new ImageView();
         b_rook_img2.setImage(b_rook); 

         // King 
         ImageView b_king_img = new ImageView();
         b_king_img.setImage(b_king);
         ImageView b_queen_img = new ImageView();
         b_queen_img.setImage(b_queen);

         blackBricks.add(b_pawn_img1);
         blackBricks.add(b_pawn_img2);
         blackBricks.add(b_pawn_img3);
         blackBricks.add(b_pawn_img4);
         blackBricks.add(b_pawn_img5);
         blackBricks.add(b_pawn_img6);
         blackBricks.add(b_pawn_img7);
         blackBricks.add(b_pawn_img8);

         blackBricks.add(b_rook_img1);
         blackBricks.add(b_bishop_img1);
         blackBricks.add(b_knight_img1);

         blackBricks.add(b_king_img);
         blackBricks.add(b_queen_img);
      
         blackBricks.add(b_knight_img2);
         blackBricks.add(b_bishop_img2);
         blackBricks.add(b_rook_img2);

         

         // White 

         // Pawns
         ImageView w_pawn_img1 = new ImageView();
         w_pawn_img1.setImage(w_pawn);
         ImageView w_pawn_img2 = new ImageView();
         w_pawn_img2.setImage(w_pawn);  
         ImageView w_pawn_img3 = new ImageView();
         w_pawn_img3.setImage(w_pawn);
         ImageView w_pawn_img4 = new ImageView();
         w_pawn_img4.setImage(w_pawn);  
         ImageView w_pawn_img5 = new ImageView();
         w_pawn_img5.setImage(w_pawn);
         ImageView w_pawn_img6 = new ImageView();
         w_pawn_img6.setImage(w_pawn);  
         ImageView w_pawn_img7 = new ImageView();
         w_pawn_img7.setImage(w_pawn);
         ImageView w_pawn_img8 = new ImageView();
         w_pawn_img8.setImage(w_pawn);  

         // Rooks
         ImageView w_bishop_img1 = new ImageView();
         w_bishop_img1.setImage(w_bishop);
         ImageView w_knight_img1 = new ImageView();
         w_knight_img1.setImage(w_knight);
         ImageView w_rook_img1 = new ImageView();
         w_rook_img1.setImage(w_rook);

         ImageView w_knight_img2 = new ImageView();
         w_knight_img2.setImage(w_knight);
         ImageView w_bishop_img2 = new ImageView();
         w_bishop_img2.setImage(w_pawn);  
         ImageView w_rook_img2 = new ImageView();
         w_rook_img2.setImage(w_rook);

         // King 	
         ImageView w_king_img = new ImageView();
         w_king_img.setImage(w_king);
         ImageView w_queen_img = new ImageView();
         w_queen_img.setImage(w_queen);


         
         whiteBricks.add(w_rook_img1);
         whiteBricks.add(w_bishop_img1);
         whiteBricks.add(w_knight_img1);
        

         whiteBricks.add(w_king_img);
         whiteBricks.add(w_queen_img);

         whiteBricks.add(w_knight_img2);
         whiteBricks.add(w_bishop_img2);    
         whiteBricks.add(w_rook_img2);

      
         whiteBricks.add(w_pawn_img1);
         whiteBricks.add(w_pawn_img2);
         whiteBricks.add(w_pawn_img3);
         whiteBricks.add(w_pawn_img4);
         whiteBricks.add(w_pawn_img5);
         whiteBricks.add(w_pawn_img6);
         whiteBricks.add(w_pawn_img7);
         whiteBricks.add(w_pawn_img8);

         // Black 
         /* 
         Rectangle2D b_viewportPawn1 = new Rectangle2D(40, 35, 110, 110);
         b_pawn_img1.setViewport(b_viewportPawn1);
         Rectangle2D b_viewportPawn2 = new Rectangle2D(40, 35, 110, 110);
         b_pawn_img2.setViewport(b_viewportPawn2);
         Rectangle2D b_viewportPawn3 = new Rectangle2D(40, 35, 110, 110);
         b_pawn_img3.setViewport(b_viewportPawn3);
         Rectangle2D b_viewportPawn4 = new Rectangle2D(40, 35, 110, 110);
         b_pawn_img4.setViewport(b_viewportPawn4);
         Rectangle2D b_viewportPaw5 = new Rectangle2D(40, 35, 110, 110);
         b_pawn_img5.setViewport(b_viewportPawn2);
         Rectangle2D b_viewportPawn6 = new Rectangle2D(40, 35, 110, 110);
         b_pawn_img6.setViewport(b_viewportPawn6);

         Rectangle2D b_viewportBishop1 = new Rectangle2D(40, 35, 110, 110);
         b_bishop_img1.setViewport(b_viewportBishop1);
         Rectangle2D b_viewportKnight1 = new Rectangle2D(40, 35, 110, 110);
         b_knight_img1.setViewport(b_viewportKnight1);
         Rectangle2D b_viewportRook1 = new Rectangle2D(40, 35, 110, 110);
         b_rook_img1.setViewport(b_viewportRook1);

         Rectangle2D b_viewportBishop2 = new Rectangle2D(40, 35, 110, 110);
         b_bishop_img2.setViewport(b_viewportBishop1);
         Rectangle2D b_viewportKnight2 = new Rectangle2D(40, 35, 110, 110);
         b_knight_img2.setViewport(b_viewportKnight2);
         Rectangle2D b_viewportRook2 = new Rectangle2D(40, 35, 110, 110);
         b_rook_img2.setViewport(b_viewportRook2);

         Rectangle2D b_viewportKing = new Rectangle2D(40, 35, 110, 110);
         b_king_img.setViewport(b_viewportKing);
         Rectangle2D b_viewportQueen = new Rectangle2D(40, 35, 110, 110);
         b_queen_img.setViewport(b_viewportQueen);

         // White

         Rectangle2D w_viewportPawn1 = new Rectangle2D(40, 35, 110, 110);
         w_pawn_img1.setViewport(w_viewportPawn1);
         Rectangle2D w_viewportPawn2 = new Rectangle2D(40, 35, 110, 110);
         w_pawn_img2.setViewport(w_viewportPawn2);
         Rectangle2D w_viewportPawn3 = new Rectangle2D(40, 35, 110, 110);
         w_pawn_img3.setViewport(w_viewportPawn3);
         Rectangle2D w_viewportPawn4 = new Rectangle2D(40, 35, 110, 110);
         w_pawn_img4.setViewport(w_viewportPawn4);
         Rectangle2D w_viewportPaw5 = new Rectangle2D(40, 35, 110, 110);
         w_pawn_img5.setViewport(w_viewportPawn2);
         Rectangle2D w_viewportPawn6 = new Rectangle2D(40, 35, 110, 110);
         w_pawn_img6.setViewport(w_viewportPawn6);

         Rectangle2D w_viewportBishop1 = new Rectangle2D(40, 35, 110, 110);
         w_bishop_img1.setViewport(w_viewportBishop1);
         Rectangle2D w_viewportKnight1 = new Rectangle2D(40, 35, 110, 110);
         w_knight_img1.setViewport(w_viewportKnight1);
         Rectangle2D w_viewportRook1 = new Rectangle2D(40, 35, 110, 110);
         w_rook_img1.setViewport(w_viewportRook1);

         Rectangle2D w_viewportBishop2 = new Rectangle2D(40, 35, 110, 110);
         w_bishop_img2.setViewport(w_viewportBishop1);
         Rectangle2D w_viewportKnight2 = new Rectangle2D(40, 35, 110, 110);
         w_knight_img2.setViewport(w_viewportKnight2);
         Rectangle2D w_viewportRook2 = new Rectangle2D(40, 35, 110, 110);
         w_rook_img2.setViewport(w_viewportRook2);

         Rectangle2D w_viewportKing = new Rectangle2D(40, 35, 110, 110);
         w_king_img.setViewport(w_viewportKing);
         Rectangle2D w_viewportQueen = new Rectangle2D(40, 35, 110, 110);
         w_queen_img.setViewport(w_viewportQueen); */ 


		Pane pane = new Pane();


		for (int i=1; i<=8; i++) {
			for (int y=1; y<=8; y++) {
			rectangleChessBoard = new Rectangle(100*(y-1),100*(i-1),100,100);
			if (white == false) {
				rectangleChessBoard.setFill(Color.DARKGREY);
				chessBoard[i][y] = rectangleChessBoard;
			}
			else {
				rectangleChessBoard.setFill(Color.WHITE);
			    chessBoard[i][y] = rectangleChessBoard;
			}
			pane.getChildren().add(rectangleChessBoard);
			white = !white;
			// System.out.println(white);
			}
			white = !white;
		}

		int counter = 0;


		for(int i=1; i<=2; i++) {

			for(int y=1; y<=8; y++) {
				whiteBricks.get(counter).setX(chessBoard[i][y].getX()+16);
				whiteBricks.get(counter).setY(chessBoard[i][y].getY()+16);
				pane.getChildren().add(whiteBricks.get(counter));
				counter++;
			}
		}  

		counter = 0;

		for(int i=7; i<=8; i++) {

			for(int y=1; y<=8; y++) {
				blackBricks.get(counter).setX(chessBoard[i][y].getX()+16);
				blackBricks.get(counter).setY(chessBoard[i][y].getY()+16);
				pane.getChildren().add(blackBricks.get(counter));
				counter++;
			}
		}  
		// }

		System.out.println(whiteBricks.size());

      Serialize serialize = new Serialize();
      //try {
      ResultatParti resultat = (ResultatParti) serialize.deserialiserResultatParti2("George_Mike_10.10.10_10.10.ser");
     // System.out.println(resultat);


      ArrayList<String> trekk = resultat.trekk;
      // System.out.println(trekk.get(4));

      ArrayList<String> oldValue = new ArrayList<String>();
      ArrayList<String> newValue = new ArrayList<String>();

      //  String[] tekstvar = str.split("-",trekk);

      System.out.println(trekk.get(0).charAt(1));

      System.out.println(trekk);

      // resultat.trekk.get(5) = "";

      String tekstvar = "tc2-tcx";
      System.out.println(tekstvar.length());
      String lowerCase;
      int tall;

      for(int i=0; i<trekk.size(); i++) {

         tall = (int)trekk.get(i).charAt(1)-(96);
         tekstvar = tall + "" + trekk.get(i).charAt(2);
         oldValue.add(tekstvar);

         if (trekk.get(i).length() >= 8) {
         tall = (int)trekk.get(i).charAt(5)-(96);
         tekstvar = tall + "" + trekk.get(i).charAt(7);
         newValue.add(tekstvar); 
          }

         else {
           tall = (int)trekk.get(i).charAt(5)-(96);         
            tekstvar = tall + "" + trekk.get(i).charAt(6);
            newValue.add(tekstvar); 
          }  
      }
      System.out.println(oldValue);
      System.out.println(newValue);



		Scene scene = new Scene(pane,HEIGHT,WIDTH);
		primaryStage.setScene(scene);
		primaryStage.show();

      double ruteX;
      double ruteY;

   //    Rectangle rute; 
   // rute = chessBoard[(oldValue.get(0).charAt(0))][(oldValue.get(0).charAt(1))];
    //   rute = chessBoard[3][4];
       int oldValue1 = (int)oldValue.get(2).charAt(0)-48;
       int oldValue2 = (int)oldValue.get(2).charAt(1)-48;

       int newValue1 = (int)newValue.get(2).charAt(0)-48;
       int newValue2 = (int)newValue.get(2).charAt(1)-48;
    System.out.println(oldValue1);
    System.out.println(oldValue2);

   //  ImageView currentPiece;



		AnimationTimer animationTimer = new AnimationTimer() {
		 	
		 	@Override 
		 	public void handle(long now) {


              // int value1 = (int)oldValue.get(0).charAt(0);
               //int value2 = (int)oldValue.get(0).charAt(1);
               rute = chessBoard[oldValue2+1][oldValue1+1];
               for(int i=0; i<whiteBricks.size(); i++) {
                  if (rute.getX() == (whiteBricks.get(i).getX()+16) && rute.getY() == (whiteBricks.get(i).getY() +16))
                     currentPiece = whiteBricks.get(i);
               }
               for(int i=0; i<blackBricks.size(); i++) {
                  if (rute.getX() == (blackBricks.get(i).getX()+16) && rute.getY() == (blackBricks.get(i).getY() +16))
                     // currentPiece = whiteBricks.get(i);
                     currentPiece = blackBricks.get(i);
               }

               System.out.println(currentPiece);
              // currentPiece.setX(newValue1+16);
              //  currentPiece.setY(newValue2+16);

				}
		
		 };
		
		 animationTimer.start();
		
		}



	public static void main(String[] args){
		launch(args);
	}

   public void regnUtTrekk() throws Exception {
      Serialize serialize = new Serialize();
      ResultatParti resultat = serialize.deserialiserResultatParti("Henrik_Thodesen_10.10.10_21.39.ser");
      System.out.println(resultat);
   }

	public void addChessPieces() {

	}



} 