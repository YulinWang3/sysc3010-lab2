# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time

for n in sys.argv:
  host = sys.argv[n]
  textport = sys.argv[n + 1]

  s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
  port = int(textport)
  server_address = (host, port)

  while 1:
    print ("Message" + n)
    data = sys.stdin.readline().strip()
    if not len(data):
        break
#    s.sendall(data.encode('utf-8'))
    s.sendto(data.encode('utf-8'), server_address)

s.shutdown(1)
