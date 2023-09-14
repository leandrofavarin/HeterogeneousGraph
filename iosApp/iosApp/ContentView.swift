import SwiftUI
import shared

let component = AppComponentKt.createComponent()

struct ContentView: View {
  let books = component.myDatabase.bookQueries.selectAll().executeAsList()

	var body: some View {
    List(books, id: \.self) { book in
      Text(book.description())
    }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
