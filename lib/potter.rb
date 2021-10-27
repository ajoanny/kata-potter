def price books
  unique_book_number = books.uniq.size

  if unique_book_number == 3
    return (8*100*books.size - unique_book_number*8*10) / 100.0
  elsif unique_book_number == 2
    return (8*100*books.size - unique_book_number*8*5) / 100.0
  else
    return (8*100*books.size - unique_book_number*8*0) / 100.0
  end
end
